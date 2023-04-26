package com.legionlord.legionlordbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Rank {
    BRONZE(0, 1199),
    SILVER(1200, 1399),
    GOLD(1400, 1599),
    PLATINUM(1600, 1799),
    DIAMOND(1800, 1999),
    EXPERT(2000, 2199),
    MASTER(2200, 2399),
    SENIOR_MASTER(2400, 2599),
    GRANDMASTER(2600, 2799),
    LEGEND(2800, 9999);

    private int minRating;
    private int maxRating;


}
