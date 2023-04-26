package com.legionlord.legionlordbackend.scheduler;

import com.legionlord.legionlordbackend.entity.GameType;
import com.legionlord.legionlordbackend.entity.Rank;
import com.legionlord.legionlordbackend.entity.StatisticsEntity;
import com.legionlord.legionlordbackend.entity.statistics.*;
import com.legionlord.legionlordbackend.mapper.StatisticsMapper;
import com.legionlord.legionlordbackend.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
@EnableAsync
public class StatisticsScheduler {

    private StatisticsRepository statisticsRepository;
    private StatisticsMapper statisticsMapper;
    private EndingWaveStatisticsRepository endingWaveStatisticsRepository;
    private LegionStatisticsRepository legionStatisticsRepository;
    private SpellStatisticsRepository spellStatisticsRepository;
    private RollStatisticsRepository rollStatisticsRepository;
    private FirstWaveFightersStatisticsRepository firstWaveFightersStatisticsRepository;
    private UnitStatisticsRepository unitStatisticsRepository;
    private PatchRepository patchRepository;
    private StatisticsRunRepository statisticsRunRepository;

    @Async
    @Scheduled(cron = "0 0 4 * * ?")
    public void calculateStatisticsForEndingWave() {
        System.out.println("Fetching statistics");

        Rank[] ranks = Rank.values();
        GameType gameType = GameType.NORMAL;
        String patch = patchRepository.findFirstByOrderByCreateTsDesc().orElseThrow(() -> new RuntimeException("Error fetching last patch")).getPatch();

        StatisticsRunEntity statisticsRunEntity = statisticsRunRepository.save(StatisticsRunEntity.builder()
                .patch(patch).build());

        Arrays.stream(ranks).forEach(rank -> {
            fetchEndingWaveStatistics(statisticsRunEntity, rank, gameType, patch);
            fetchLegionStatistics(statisticsRunEntity, rank, gameType, patch);
            fetchSpellStatistics(statisticsRunEntity, rank, gameType, patch);
            fetchRollStatistics(statisticsRunEntity, rank, gameType, patch);
            fetchFirstWaveFightersStatistics(statisticsRunEntity, rank, gameType, patch);
            fetchUnitStatistics(statisticsRunEntity, rank, gameType, patch);
        });

        System.out.println("Saved statistics");
    }

    private void fetchLegionStatistics(StatisticsRunEntity statisticsRunEntity, Rank rank, GameType gameType, String patch) {
        List<StatisticsEntity> legionStats = statisticsRepository.fetchLegionStatistics(rank.getMinRating(), rank.getMaxRating(), gameType.getQueueName(), patch);
        List<LegionStatisticsEntity> legionStatisticsEntities = legionStats
                .stream()
                .map(stat -> statisticsMapper.statsToLegion(stat, statisticsRunEntity, rank, gameType, patch))
                .toList();
        legionStatisticsRepository.saveAll(legionStatisticsEntities);
    }

    private void fetchEndingWaveStatistics(StatisticsRunEntity statisticsRunEntity, Rank rank, GameType gameType, String patch) {
        List<StatisticsEntity> endingWaveStats = statisticsRepository.fetchEndingWaveStatistics(rank.getMinRating(), rank.getMaxRating(), gameType.getQueueName(), patch);
        List<EndingWaveStatisticsEntity> endingWaveStatisticsEntities = endingWaveStats
                .stream()
                .map(stat -> statisticsMapper.statsToEndingWave(stat, statisticsRunEntity, rank, gameType, patch))
                .toList();
        endingWaveStatisticsRepository.saveAll(endingWaveStatisticsEntities);
    }

    private void fetchSpellStatistics(StatisticsRunEntity statisticsRunEntity, Rank rank, GameType gameType, String patch) {
        List<StatisticsEntity> spellStats = statisticsRepository.fetchSpellStatistics(rank.getMinRating(), rank.getMaxRating(), gameType.getQueueName(), patch);
        List<SpellStatisticsEntity> spellStatisticsEntities = spellStats
                .stream()
                .map(stat -> statisticsMapper.statsToSpell(stat, statisticsRunEntity, rank, gameType, patch))
                .toList();
        spellStatisticsRepository.saveAll(spellStatisticsEntities);
    }

    private void fetchRollStatistics(StatisticsRunEntity statisticsRunEntity, Rank rank, GameType gameType, String patch) {
        List<StatisticsEntity> rollStats = statisticsRepository.fetchRollStatistics(rank.getMinRating(), rank.getMaxRating(), gameType.getQueueName(), patch);
        List<RollStatisticsEntity> rollStatisticsEntities = rollStats
                .stream()
                .map(stat -> statisticsMapper.statsToRoll(stat, statisticsRunEntity, rank, gameType, patch))
                .toList();
        rollStatisticsRepository.saveAll(rollStatisticsEntities);
    }

    private void fetchFirstWaveFightersStatistics(StatisticsRunEntity statisticsRunEntity, Rank rank, GameType gameType, String patch) {
        List<StatisticsEntity> firstWaveFightersStats = statisticsRepository.fetchFirstWaveFighterStatistics(rank.getMinRating(), rank.getMaxRating(), gameType.getQueueName(), patch);
        List<FirstWaveFighterStatisticsEntity> firstWaveFighterStatisticsEntities = firstWaveFightersStats
                .stream()
                .map(stat -> statisticsMapper.statsToFirstWaveFighters(stat, statisticsRunEntity, rank, gameType, patch))
                .toList();
        firstWaveFightersStatisticsRepository.saveAll(firstWaveFighterStatisticsEntities);
    }

    private void fetchUnitStatistics(StatisticsRunEntity statisticsRunEntity, Rank rank, GameType gameType, String patch) {
        List<StatisticsEntity> unitStats = statisticsRepository.fetchUnitStatistics(rank.getMinRating(), rank.getMaxRating(), gameType.getQueueName(), patch);
        List<UnitStatisticsEntity> unitStatisticsEntities = unitStats
                .stream()
                .map(stat -> statisticsMapper.statsToUnit(stat, statisticsRunEntity, rank, gameType, patch))
                .toList();
        unitStatisticsRepository.saveAll(unitStatisticsEntities);
    }
}
