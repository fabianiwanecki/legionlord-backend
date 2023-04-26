package com.legionlord.legionlordbackend.mapper;

import com.legionlord.legionlordbackend.dto.GamesResDto;
import com.legionlord.legionlordbackend.dto.GamesResPlayerData;
import com.legionlord.legionlordbackend.entity.GameEntity;
import com.legionlord.legionlordbackend.entity.GamesPlayerDataEntity;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = "spring")
public interface GameMapper {
    List<GameEntity> dtoToEntity(List<GamesResDto> games);

    GameEntity dtoToEntity(GamesResDto game);

    @Mapping(source = "rolls", target = "rolls", qualifiedByName = "mapRolls")
    GamesPlayerDataEntity dtoToEntity(GamesResPlayerData playerData);

    @AfterMapping
    default void calledWithSourceAndTargetType(@MappingTarget GameEntity game) {
        game.getPlayersData().forEach(player -> {
            player.setGame(game);
            player.setFirstWaveFighters(player.getFirstWaveFighters().stream().sorted().toList());
        });
    }

    @Named("mapRolls")
    default List<String> mapRolls(String value) {
        if (value == null) return new ArrayList<>();
        return Arrays.stream(value.split(", ")).toList();
    }

    default List<String> map(String value) {
        if (value == null) return new ArrayList<>();
        return Arrays.stream(value.split(",")).toList();
    }
}
