package com.legionlord.legionlordbackend.mapper;

import com.legionlord.legionlordbackend.entity.GameType;
import com.legionlord.legionlordbackend.entity.Rank;
import com.legionlord.legionlordbackend.entity.StatisticsEntity;
import com.legionlord.legionlordbackend.entity.statistics.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StatisticsMapper {

    @Mapping(source = "statisticsRunEntity.uuid", target = "statisticsUuid")
    @Mapping(source = "statisticsEntity.id", target = "endingWave")
    @Mapping(source = "statisticsEntity.wins", target = "gamesEnded")
    @Mapping(source = "statisticsEntity.total", target = "gamesTotal")
    EndingWaveStatisticsEntity statsToEndingWave(StatisticsEntity statisticsEntity, StatisticsRunEntity statisticsRunEntity, Rank rank, GameType gameType, String patch);

    @Mapping(source = "statisticsRunEntity.uuid", target = "statisticsUuid")
    @Mapping(source = "statisticsEntity.id", target = "legion")
    @Mapping(source = "statisticsEntity.wins", target = "gamesEnded")
    @Mapping(source = "statisticsEntity.total", target = "gamesTotal")
    LegionStatisticsEntity statsToLegion(StatisticsEntity statisticsEntity, StatisticsRunEntity statisticsRunEntity, Rank rank, GameType gameType, String patch);

    @Mapping(source = "statisticsRunEntity.uuid", target = "statisticsUuid")
    @Mapping(source = "statisticsEntity.id", target = "spell")
    @Mapping(source = "statisticsEntity.wins", target = "gamesEnded")
    @Mapping(source = "statisticsEntity.total", target = "gamesTotal")
    SpellStatisticsEntity statsToSpell(StatisticsEntity statisticsEntity, StatisticsRunEntity statisticsRunEntity, Rank rank, GameType gameType, String patch);

    @Mapping(source = "statisticsRunEntity.uuid", target = "statisticsUuid")
    @Mapping(source = "statisticsEntity.id", target = "roll")
    @Mapping(source = "statisticsEntity.wins", target = "gamesEnded")
    @Mapping(source = "statisticsEntity.total", target = "gamesTotal")
    RollStatisticsEntity statsToRoll(StatisticsEntity statisticsEntity, StatisticsRunEntity statisticsRunEntity, Rank rank, GameType gameType, String patch);

    @Mapping(source = "statisticsRunEntity.uuid", target = "statisticsUuid")
    @Mapping(source = "statisticsEntity.id", target = "fighters", qualifiedByName = "fightersMapper")
    @Mapping(source = "statisticsEntity.wins", target = "gamesEnded")
    @Mapping(source = "statisticsEntity.total", target = "gamesTotal")
    FirstWaveFighterStatisticsEntity statsToFirstWaveFighters(StatisticsEntity statisticsEntity, StatisticsRunEntity statisticsRunEntity, Rank rank, GameType gameType, String patch);

    @Mapping(source = "statisticsRunEntity.uuid", target = "statisticsUuid")
    @Mapping(source = "statisticsEntity.id", target = "unit")
    @Mapping(source = "statisticsEntity.wins", target = "gamesEnded")
    @Mapping(source = "statisticsEntity.total", target = "gamesTotal")
    UnitStatisticsEntity statsToUnit(StatisticsEntity statisticsEntity, StatisticsRunEntity statisticsRunEntity, Rank rank, GameType gameType, String patch);

    @Named("fightersMapper")
    default List<String> fightersMapper(String fighters) {
        return Arrays.asList(fighters.substring(1, fighters.length() - 1).split(","));
    }
}
