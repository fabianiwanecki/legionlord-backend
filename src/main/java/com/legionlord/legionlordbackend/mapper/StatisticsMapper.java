package com.legionlord.legionlordbackend.mapper;

import com.legionlord.legionlordbackend.dto.*;
import com.legionlord.legionlordbackend.entity.GameType;
import com.legionlord.legionlordbackend.entity.Rank;
import com.legionlord.legionlordbackend.entity.StatisticsEntity;
import com.legionlord.legionlordbackend.entity.statistics.*;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Arrays;
import java.util.Collections;
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

    List<EndingWaveStatisticsDto> endingWaveEntityToDto(List<EndingWaveStatisticsEntity> entities);

    @Mapping(source = "entity", target = "endingRate", qualifiedByName = "endingRateMapper")
    EndingWaveStatisticsDto endingWaveEntityToDto(EndingWaveStatisticsEntity entity);

    @Named("endingRateMapper")
    default Double endingRateMapper(EndingWaveStatisticsEntity entity) {
        return (double) entity.getGamesEnded() / entity.getGamesTotal();
    }

    List<FirstWaveFighterStatisticsDto> firstWaveFightersEntityToDto(List<FirstWaveFighterStatisticsEntity> entities, @Context long totalGames);

    @Mapping(source = "fighters", target = "fighters", qualifiedByName = "firstWaveFightersMapper")
    @Mapping(source = "entity", target = "winRate", qualifiedByName = "firstWaveFightersWinRateMapper")
    @Mapping(source = "entity", target = "pickRate", qualifiedByName = "firstWaveFightersPickRateMapper")
    FirstWaveFighterStatisticsDto firstWaveFightersEntityToDto(FirstWaveFighterStatisticsEntity entity, @Context long totalGames);

    @Named("firstWaveFightersWinRateMapper")
    default Double firstWaveFightersWinRateMapper(FirstWaveFighterStatisticsEntity entity) {
        return (double) entity.getGamesEnded() / entity.getGamesTotal();
    }

    @Named("firstWaveFightersPickRateMapper")
    default Double firstWaveFightersPickRateMapper(FirstWaveFighterStatisticsEntity entity, @Context long totalGames) {
        return (double) entity.getGamesTotal() / totalGames;
    }

    @Named("firstWaveFightersMapper")
    default List<String> firstWaveFightersMapper(List<String> fighters) {
        if (fighters == null) return Collections.emptyList();
        return fighters.stream().map(fighter -> fighter.replace("\"", "")).toList();
    }

    List<LegionStatisticsDto> legionEntityToDto(List<LegionStatisticsEntity> entities, @Context long totalGames);

    @Mapping(source = "entity", target = "winRate", qualifiedByName = "legionWinRateMapper")
    @Mapping(source = "entity", target = "pickRate", qualifiedByName = "legionPickRateMapper")
    LegionStatisticsDto legionEntityToDto(LegionStatisticsEntity entity, @Context long totalGames);

    @Named("legionWinRateMapper")
    default Double legionWinRateMapper(LegionStatisticsEntity entity) {
        return (double) entity.getGamesEnded() / entity.getGamesTotal();
    }

    @Named("legionPickRateMapper")
    default Double legionPickRateMapper(LegionStatisticsEntity entity, @Context long totalGames) {
        return (double) entity.getGamesTotal() / totalGames;
    }

    List<SpellStatisticsDto> spellEntityToDto(List<SpellStatisticsEntity> entities, @Context long totalGames);

    @Mapping(source = "entity", target = "winRate", qualifiedByName = "spellWinRateMapper")
    @Mapping(source = "entity", target = "pickRate", qualifiedByName = "spellPickRateMapper")
    SpellStatisticsDto spellEntityToDto(SpellStatisticsEntity entity, @Context long totalGames);

    @Named("spellWinRateMapper")
    default Double spellWinRateMapper(SpellStatisticsEntity entity) {
        return (double) entity.getGamesEnded() / entity.getGamesTotal();
    }

    @Named("spellPickRateMapper")
    default Double spellPickRateMapper(SpellStatisticsEntity entity, @Context long totalGames) {
        return (double) entity.getGamesTotal() / totalGames;
    }

    List<RollStatisticsDto> rollEntityToDto(List<RollStatisticsEntity> entities);

    @Mapping(source = "entity", target = "winRate", qualifiedByName = "rollWinRateMapper")
    RollStatisticsDto rollEntityToDto(RollStatisticsEntity entity);

    @Named("rollWinRateMapper")
    default Double rollWinRateMapper(RollStatisticsEntity entity) {
        return (double) entity.getGamesEnded() / entity.getGamesTotal();
    }

    List<UnitStatisticsDto> unitEntityToDto(List<UnitStatisticsEntity> entities);

    @Mapping(source = "entity", target = "winRate", qualifiedByName = "unitWinRateMapper")
    UnitStatisticsDto unitEntityToDto(UnitStatisticsEntity entity);

    @Named("unitWinRateMapper")
    default Double unitWinRateMapper(UnitStatisticsEntity entity) {
        return (double) entity.getGamesEnded() / entity.getGamesTotal();
    }
}
