package com.legionlord.legionlordbackend.scheduler;

import com.legionlord.legionlordbackend.client.GamesClient;
import com.legionlord.legionlordbackend.dto.GamesResDto;
import com.legionlord.legionlordbackend.entity.GameType;
import com.legionlord.legionlordbackend.entity.PatchEntity;
import com.legionlord.legionlordbackend.repository.PatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PatchFetchScheduler {

    private GamesClient gamesClient;
    private PatchRepository patchRepository;

    @Async
    @Scheduled(cron = "0 0 0 * * ?")
    public void fetchLatestPatchVersion() {
        System.out.println("Fetching patch");

        List<GamesResDto> games = gamesClient.fetchGames(1, 0, GameType.NORMAL.getQueueName(), "date", -1, false, false, null, null, "M2vIJufiqg1I8iNjXH8d79mSdDLFIGBN8EDGTEeI");

        String latestPatch = games.stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Error occurred while fetching patch version: No games found")).version();

        boolean patchExistsInDb = patchRepository.existsById(latestPatch);

        if (!patchExistsInDb) {
            patchRepository.save(PatchEntity.builder().patch(latestPatch).build());
            System.out.println("Saved new patch: " + latestPatch);
        }
    }

}
