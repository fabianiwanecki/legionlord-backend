package com.legionlord.legionlordbackend.dto;

import java.util.Comparator;
import java.util.Objects;

public record LegionStatisticsDto(String legion, Double winRate, Double pickRate) implements Comparable<LegionStatisticsDto> {
    @Override
    public int compareTo(LegionStatisticsDto that) {
        return Objects.compare(this, that, Comparator.comparing(LegionStatisticsDto::winRate));
    }
}