package com.legionlord.legionlordbackend.scheduler;

import com.legionlord.legionlordbackend.client.GamesClient;
import com.legionlord.legionlordbackend.dto.GamesResDto;
import com.legionlord.legionlordbackend.entity.GameType;
import com.legionlord.legionlordbackend.mapper.GameMapper;
import com.legionlord.legionlordbackend.repository.GameRepository;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@EnableAsync
public class GameFetchScheduler {

    public static final int GAMES_PER_REQUEST = 50;

    private GamesClient gamesClient;
    private GameRepository gameRepository;
    private GameMapper gameMapper;

    @Async
    @Scheduled(cron = "0 10 0 * * ?")
    public void fetchGames() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dtf = new DateTimeFormatterBuilder().appendPattern(pattern).toFormatter();

        ZonedDateTime dateAfter = ZonedDateTime.now(ZoneOffset.UTC).withHour(0).withMinute(0).withSecond(0).withNano(0).minusDays(1);
        ZonedDateTime dateBefore = ZonedDateTime.now(ZoneOffset.UTC).withHour(23).withMinute(59).withSecond(59).withNano(999_999_999).minusDays(1);

        int offset = 0;

        while (true) {
            try {
                System.out.println("Fetching games with offset: " + offset);
                List<GamesResDto> gamesWithCount = gamesClient.fetchGames(GAMES_PER_REQUEST, offset, GameType.NORMAL.getQueueName(), "date", -1, true, true, dtf.format(dateBefore), dtf.format(dateAfter), "M2vIJufiqg1I8iNjXH8d79mSdDLFIGBN8EDGTEeI");

                List<GamesResDto> games = new ArrayList<>(gamesWithCount.stream().limit(gamesWithCount.size() - 1L).toList());

                System.out.println(games.size() + " games fetched");

                gameRepository.saveAll(gameMapper.dtoToEntity(games));

                System.out.println(games.size() + " games saved");

                Long count = gamesWithCount.get(gamesWithCount.size() - 1).count();

                if (count > offset + GAMES_PER_REQUEST) {
                    offset += GAMES_PER_REQUEST;
                } else {
                    System.out.println("Successfully fetched " + count + " games");
                    break;
                }
            } catch (FeignException e) {
                System.err.println("An error occurred. Retrying.");
            }
        }
    }
}
