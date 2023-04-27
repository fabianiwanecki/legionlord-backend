package com.legionlord.legionlordbackend.dto;

import java.util.List;

public record FirstWaveFighterStatisticsDto(List<String> fighters, Double winRate) {
}
