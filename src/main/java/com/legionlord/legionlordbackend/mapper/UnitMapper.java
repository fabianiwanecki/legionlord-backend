package com.legionlord.legionlordbackend.mapper;

import com.legionlord.legionlordbackend.dto.UnitDto;
import com.legionlord.legionlordbackend.dto.UnitResDto;
import com.legionlord.legionlordbackend.entity.UnitEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UnitMapper {
    List<UnitEntity> dtoToEntity(List<UnitResDto> units);

    @Mapping(source = "goldCost", target = "cost")
    @Mapping(source = "isEnabled", target = "enabled")
    UnitEntity dtoToEntity(UnitResDto unit);

    UnitDto entityToDto(UnitEntity entity);
    List<UnitDto> entityToDto(List<UnitEntity> entity);
}
