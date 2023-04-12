package com.legionlord.legionlordbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;

public record GamesResDto(@JsonProperty("_id") String id, String version, ZonedDateTime date, String queueType,
                          Integer endingWave, Long gameLength, Integer gameElo, Integer playerCount, Integer humanCount,
                          List<String> spellChoices, List<Float> leftKingPercentHp, List<Float> rightKingPercentHp,
                          String kingSpell, List<GamesResPlayerData> playersData, Long count) {
}
