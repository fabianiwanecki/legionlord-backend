package com.legionlord.legionlordbackend.scheduler;

import com.legionlord.legionlordbackend.client.GamesClient;
import com.legionlord.legionlordbackend.dto.GamesResDto;
import com.legionlord.legionlordbackend.mapper.GameMapper;
import com.legionlord.legionlordbackend.repository.GameRepository;
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
    @Scheduled(cron = "10 * * ? * *")
    public void fetchGames() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dtf = new DateTimeFormatterBuilder().appendPattern(pattern).toFormatter();

//        ZonedDateTime dateAfter = ZonedDateTime.now(ZoneOffset.UTC).withMinute(0).withSecond(0).withNano(0).minusHours(1);
//        ZonedDateTime dateBefore = ZonedDateTime.now(ZoneOffset.UTC).withMinute(59).withSecond(59).withNano(999_999_999).minusHours(1);

        ZonedDateTime dateAfter = ZonedDateTime.now(ZoneOffset.UTC).withSecond(0).withNano(0).minusHours(1);
        ZonedDateTime dateBefore = ZonedDateTime.now(ZoneOffset.UTC).withSecond(59).withNano(999_999_999).minusHours(1);

        List<GamesResDto> games = new ArrayList<>();

        int offset = 0;

        while (true) {
            System.out.println("Fetching games with offset: " + offset);
            List<GamesResDto> gamesWithCount = gamesClient.fetchGames(GAMES_PER_REQUEST,  offset, "Normal", "date", -1, true, true, dtf.format(dateBefore), dtf.format(dateAfter), "M2vIJufiqg1I8iNjXH8d79mSdDLFIGBN8EDGTEeI");
            games.addAll(gamesWithCount.stream().limit(gamesWithCount.size() - 1).toList());

            Long count = gamesWithCount.get(gamesWithCount.size() - 1).count();

            if (count > offset + GAMES_PER_REQUEST) {
                offset += GAMES_PER_REQUEST;
            } else {
                System.out.println("Successfully fetched " + count + " games");
                break;
            }
        }

        gameRepository.saveAll(gameMapper.dtoToEntity(games));

        System.out.println(games.size() + " saved");
    }
}
