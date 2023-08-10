package com.legionlord.legionlordbackend.dto;

public record UnitDto(
        String id,
        String unitId,
        String name,
        String iconPath,
        Integer cost,
        Boolean enabled
) {}
