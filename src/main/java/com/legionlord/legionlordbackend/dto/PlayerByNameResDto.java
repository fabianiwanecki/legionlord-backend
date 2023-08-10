package com.legionlord.legionlordbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PlayerByNameResDto(@JsonProperty("_id") String id, String playerName) {
}
