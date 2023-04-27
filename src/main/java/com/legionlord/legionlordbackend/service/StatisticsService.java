package com.legionlord.legionlordbackend.service;

import com.legionlord.legionlordbackend.dto.*;
import com.legionlord.legionlordbackend.entity.GameType;
import com.legionlord.legionlordbackend.entity.Rank;
import com.legionlord.legionlordbackend.entity.statistics.*;
import com.legionlord.legionlordbackend.mapper.StatisticsMapper;
import com.legionlord.legionlordbackend.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

        return statisticsMapper.endingWaveEntityToDto(endingWaveStatisticsEntityList);
    }

    public List<FirstWaveFighterStatisticsDto> getLatestFirstWaveFightersStatistics(GameType gameType, Rank rank) {
        StatisticsRunEntity statisticsRunEntity = statisticsRunRepository.findFirstByOrderByCreateTsDesc();

        List<FirstWaveFighterStatisticsEntity> firstWaveFighterStatisticsEntityList = firstWaveFightersStatisticsRepository.findAllByStatisticsUuidAndRankAndGameType(statisticsRunEntity.getUuid(), rank, gameType);

        return statisticsMapper.firstWaveFightersEntityToDto(firstWaveFighterStatisticsEntityList);
    }

    public List<SpellStatisticsDto> getLatestSpellStatistics(GameType gameType, Rank rank) {
        StatisticsRunEntity statisticsRunEntity = statisticsRunRepository.findFirstByOrderByCreateTsDesc();

        List<SpellStatisticsEntity> spellStatisticsEntityList = spellStatisticsRepository.findAllByStatisticsUuidAndRankAndGameType(statisticsRunEntity.getUuid(), rank, gameType);

        return statisticsMapper.spellEntityToDto(spellStatisticsEntityList);
    }

    public List<RollStatisticsDto> getLatestRollStatistics(GameType gameType, Rank rank) {
        StatisticsRunEntity statisticsRunEntity = statisticsRunRepository.findFirstByOrderByCreateTsDesc();

        List<RollStatisticsEntity> rollStatisticsEntityList = rollStatisticsRepository.findAllByStatisticsUuidAndRankAndGameType(statisticsRunEntity.getUuid(), rank, gameType);

        return statisticsMapper.rollEntityToDto(rollStatisticsEntityList);
    }

    public List<LegionStatisticsDto> getLatestLegionStatistics(GameType gameType, Rank rank) {
        StatisticsRunEntity statisticsRunEntity = statisticsRunRepository.findFirstByOrderByCreateTsDesc();

        List<LegionStatisticsEntity> legionStatisticsEntityList = legionStatisticsRepository.findAllByStatisticsUuidAndRankAndGameType(statisticsRunEntity.getUuid(), rank, gameType);

        return statisticsMapper.legionEntityToDto(legionStatisticsEntityList);
    }

    public List<UnitStatisticsDto> getLatestUnitStatistics(GameType gameType, Rank rank) {
        StatisticsRunEntity statisticsRunEntity = statisticsRunRepository.findFirstByOrderByCreateTsDesc();

        List<UnitStatisticsEntity> unitStatisticsEntityList = unitStatisticsRepository.findAllByStatisticsUuidAndRankAndGameType(statisticsRunEntity.getUuid(), rank, gameType);

        return statisticsMapper.unitEntityToDto(unitStatisticsEntityList);
    }
}
