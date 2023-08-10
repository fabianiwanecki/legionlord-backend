package com.legionlord.legionlordbackend.dto;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public record FirstWaveFighterStatisticsDto(List<String> fighters, Double winRate, Double pickRate) implements Comparable<FirstWaveFighterStatisticsDto> {
    @Override
    public int compareTo(FirstWaveFighterStatisticsDto that) {
        return Objects.compare(this, that, Comparator.comparing(FirstWaveFighterStatisticsDto::winRate));
    }
}