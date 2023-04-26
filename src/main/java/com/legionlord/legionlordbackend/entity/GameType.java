package com.legionlord.legionlordbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameType {
    NORMAL("Normal"),
    CLASSIC("Classic"),
    ARCADE("Arcade"),
    COOP("Coop"),
    CUSTOM("Custom");

    private String queueName;
}
