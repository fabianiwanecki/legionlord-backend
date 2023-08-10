package com.legionlord.legionlordbackend.dto;

import java.util.Comparator;
import java.util.Objects;

public record RollStatisticsDto(String roll, Double winRate) implements Comparable<RollStatisticsDto> {
    @Override
    public int compareTo(RollStatisticsDto that) {
        return Objects.compare(this, that, Comparator.comparing(RollStatisticsDto::winRate));
    }
}