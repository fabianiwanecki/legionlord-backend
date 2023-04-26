package com.legionlord.legionlordbackend.entity.statistics;

import com.legionlord.legionlordbackend.entity.Auditable;
import com.legionlord.legionlordbackend.entity.GameType;
import com.legionlord.legionlordbackend.entity.Rank;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "statistics_legions")
public class LegionStatisticsEntity extends Auditable {

    @Id
    @GeneratedValue
    private UUID uuid;

    private UUID statisticsUuid;

    private String legion;

    private Integer gamesEnded;

    private Integer gamesTotal;

    private String patch;

    @Enumerated(EnumType.STRING)
    private GameType gameType;

    @Enumerated(EnumType.STRING)
    private Rank rank;
}
