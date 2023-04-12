package com.legionlord.legionlordbackend.mapper;

import com.legionlord.legionlordbackend.dto.GamesResDto;
import com.legionlord.legionlordbackend.entity.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Mapper(componentModel = "spring")
public interface GameMapper {
    List<GameEntity> dtoToEntity(List<GamesResDto> games);

    GameEntity dtoToEntity(GamesResDto game);

    @AfterMapping
    default void calledWithSourceAndTargetType(SourceEntity anySource, @TargetType Class<?> targetType) {
        // ...
    }

    default List<PlayerDataFightersEntity> mapBuildPerWave(List<List<String>> value) {
        if (value == null) return null;

        return IntStream.range(0, value.size()).mapToObj(waveIndex ->
                PlayerDataFightersEntity.builder().fightersWithLocation(value.get(waveIndex)).wave(waveIndex + 1).build()
        ).toList();
    }

    default List<PlayerDataKingUpgradesEntity> mapKingUpgradesPerWave(List<List<String>> value) {
        if (value == null) return null;

        return IntStream.range(0, value.size()).mapToObj(waveIndex ->
                PlayerDataKingUpgradesEntity.builder().kingUpgrades(value.get(waveIndex)).wave(waveIndex + 1).build()
        ).toList();
    }

    default List<PlayerDataKingUpgradesOpponentEntity> mapOpponentKingUpgradesPerWave(List<List<String>> value) {
        if (value == null) return null;

        return IntStream.range(0, value.size()).mapToObj(waveIndex ->
                PlayerDataKingUpgradesOpponentEntity.builder().kingUpgrades(value.get(waveIndex)).wave(waveIndex + 1).build()
        ).toList();
    }

    default List<PlayerDataLeaksEntity> mapLeaksPerWave(List<List<String>> value) {
        if (value == null) return null;

        return IntStream.range(0, value.size()).mapToObj(waveIndex ->
                PlayerDataLeaksEntity.builder().leaks(value.get(waveIndex)).wave(waveIndex + 1).build()
        ).toList();
    }

    default List<PlayerDataMercenariesReceivedEntity> mapMercenariesReceivedPerWave(List<List<String>> value) {
        if (value == null) return null;

        return IntStream.range(0, value.size()).mapToObj(waveIndex ->
                PlayerDataMercenariesReceivedEntity.builder().mercenaries(value.get(waveIndex)).wave(waveIndex + 1).build()
        ).toList();
    }

    default List<PlayerDataMercenariesSentEntity> mapMercenariesSentPerWave(List<List<String>> value) {
        if (value == null) return null;

        return IntStream.range(0, value.size()).mapToObj(waveIndex ->
                PlayerDataMercenariesSentEntity.builder().mercenaries(value.get(waveIndex)).wave(waveIndex + 1).build()
        ).toList();
    }

    default List<String> map(String value) {
        if (value == null) return new ArrayList<>();
        return Arrays.stream(value.split(",")).toList();
    }
}
