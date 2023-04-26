package com.legionlord.legionlordbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UnitResDto(@JsonProperty("_id") String id, String unitId, String iconPath, String name, Integer goldCost, Boolean isEnabled) {
}
