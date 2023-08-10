package com.legionlord.legionlordbackend.service;

import com.legionlord.legionlordbackend.dto.*;
import com.legionlord.legionlordbackend.entity.GameType;
import com.legionlord.legionlordbackend.entity.Rank;
import com.legionlord.legionlordbackend.entity.statistics.*;
import com.legionlord.legionlordbackend.mapper.StatisticsMapper;
import com.legionlord.legionlordbackend.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class StatisticsService {

    private StatisticsRunRepository statisticsRunRepository;
    private EndingWaveStatisticsRepository endingWaveStatisticsRepository;
    private FirstWaveFightersStatisticsRepository firstWaveFightersStatisticsRepository;
    private SpellStatisticsRepository spellStatisticsRepository;
    private RollStatisticsRepository rollStatisticsRepository;
    private LegionStatisticsRepository legionStatisticsRepository;
    private UnitStatisticsRepository unitStatisticsRepository;
    private StatisticsMapper statisticsMapper;

    public List<EndingWaveStatisticsDto> getLatestEndingWaveStatistics(GameType gameType, Rank rank) {
        StatisticsRunEntity statisticsRunEntity = statisticsRunRepository.findFirstByOrderByCreateTsDesc();

        List<EndingWaveStatisticsEntity> endingWaveStatisticsEntityList = endingWaveStatisticsRepository.findAllByStatisticsUuidAndRankAndGameType(statisticsRunEntity.getUuid(), rank, gameType);

        return statisticsMapper.endingWaveEntityToDto(endingWaveStatisticsEntityList).stream().sorted(Comparator.reverseOrder()).toList();
    }

    public List<FirstWaveFighterStatisticsDto> getLatestFirstWaveFightersStatistics(GameType gameType, Rank rank) {
        StatisticsRunEntity statisticsRunEntity = statisticsRunRepository.findFirstByOrderByCreateTsDesc();

        List<FirstWaveFighterStatisticsEntity> firstWaveFighterStatisticsEntityList = firstWaveFightersStatisticsRepository.findAllByStatisticsUuidAndRankAndGameType(statisticsRunEntity.getUuid(), rank, gameType);

        long totalGames = firstWaveFighterStatisticsEntityList.stream().mapToLong(FirstWaveFighterStatisticsEntity::getGamesTotal).reduce(0, Long::sum);

        return statisticsMapper.firstWaveFightersEntityToDto(firstWaveFighterStatisticsEntityList, totalGames).stream().filter(el -> el.pickRate() > .005D).sorted(Comparator.reverseOrder()).toList();
    }

    public List<SpellStatisticsDto> getLatestSpellStatistics(GameType gameType, Rank rank) {
        StatisticsRunEntity statisticsRunEntity = statisticsRunRepository.findFirstByOrderByCreateTsDesc();

        List<SpellStatisticsEntity> spellStatisticsEntityList = spellStatisticsRepository.findAllByStatisticsUuidAndRankAndGameType(statisticsRunEntity.getUuid(), rank, gameType);

        long totalGames = spellStatisticsEntityList.stream().mapToLong(SpellStatisticsEntity::getGamesTotal).reduce(0, Long::sum);

        return statisticsMapper.spellEntityToDto(spellStatisticsEntityList, totalGames).stream().sorted(Comparator.reverseOrder()).toList();
    }

    public List<RollStatisticsDto> getLatestRollStatistics(GameType gameType, Rank rank) {
        StatisticsRunEntity statisticsRunEntity = statisticsRunRepository.findFirstByOrderByCreateTsDesc();

        List<RollStatisticsEntity> rollStatisticsEntityList = rollStatisticsRepository.findAllByStatisticsUuidAndRankAndGameType(statisticsRunEntity.getUuid(), rank, gameType);

        return statisticsMapper.rollEntityToDto(rollStatisticsEntityList).stream().sorted(Comparator.reverseOrder()).toList();
    }

    public List<LegionStatisticsDto> getLatestLegionStatistics(GameType gameType, Rank rank) {
        StatisticsRunEntity statisticsRunEntity = statisticsRunRepository.findFirstByOrderByCreateTsDesc();

        List<LegionStatisticsEntity> legionStatisticsEntityList = legionStatisticsRepository.findAllByStatisticsUuidAndRankAndGameType(statisticsRunEntity.getUuid(), rank, gameType);

        long totalGames = legionStatisticsEntityList.stream().mapToLong(LegionStatisticsEntity::getGamesTotal).reduce(0, Long::sum);

        return statisticsMapper.legionEntityToDto(legionStatisticsEntityList, totalGames).stream().sorted(Comparator.reverseOrder()).toList();
    }

    public List<UnitStatisticsDto> getLatestUnitStatistics(GameType gameType, Rank rank) {
        StatisticsRunEntity statisticsRunEntity = statisticsRunRepository.findFirstByOrderByCreateTsDesc();

        List<UnitStatisticsEntity> unitStatisticsEntityList = unitStatisticsRepository.findAllByStatisticsUuidAndRankAndGameType(statisticsRunEntity.getUuid(), rank, gameType);

        return statisticsMapper.unitEntityToDto(unitStatisticsEntityList).stream().sorted(Comparator.reverseOrder()).toList();
    }

    public Long getTotalGames(GameType gameType, Rank rank) {
        StatisticsRunEntity statisticsRunEntity = statisticsRunRepository.findFirstByOrderByCreateTsDesc();

        List<LegionStatisticsEntity> legionStatisticsEntityList = legionStatisticsRepository.findAllByStatisticsUuidAndRankAndGameType(statisticsRunEntity.getUuid(), rank, gameType);

        return legionStatisticsEntityList.stream().mapToLong(LegionStatisticsEntity::getGamesTotal).reduce(0, Long::sum);
    }
}
