package com.legionlord.legionlordbackend.dto;

import java.util.Comparator;
import java.util.Objects;

public record SpellStatisticsDto(String spell, Double winRate, Double pickRate) implements Comparable<SpellStatisticsDto> {
    @Override
    public int compareTo(SpellStatisticsDto that) {
        return Objects.compare(this, that, Comparator.comparing(SpellStatisticsDto::winRate));
    }
}