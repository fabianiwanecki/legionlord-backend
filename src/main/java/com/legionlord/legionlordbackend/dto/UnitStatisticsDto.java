package com.legionlord.legionlordbackend.dto;

import java.util.Comparator;
import java.util.Objects;

public record UnitStatisticsDto(String unit, Double winRate, Double pickRate) implements Comparable<UnitStatisticsDto> {
    @Override
    public int compareTo(UnitStatisticsDto that) {
        return Objects.compare(this, that, Comparator.comparing(UnitStatisticsDto::winRate));
    }
}