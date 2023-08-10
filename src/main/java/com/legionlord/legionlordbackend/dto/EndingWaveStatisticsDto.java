package com.legionlord.legionlordbackend.dto;

import java.util.Comparator;
import java.util.Objects;

public record EndingWaveStatisticsDto(Integer endingWave,
                                      Double endingRate) implements Comparable<EndingWaveStatisticsDto> {
    @Override
    public int compareTo(EndingWaveStatisticsDto that) {
        return Objects.compare(this, that, Comparator.comparing(EndingWaveStatisticsDto::endingRate));
    }
}
