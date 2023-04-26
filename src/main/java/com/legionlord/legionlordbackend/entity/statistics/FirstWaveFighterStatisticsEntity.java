package com.legionlord.legionlordbackend.entity.statistics;

import com.legionlord.legionlordbackend.entity.Auditable;
import com.legionlord.legionlordbackend.entity.GameType;
import com.legionlord.legionlordbackend.entity.Rank;
import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "statistics_first_wave_fighters")
public class FirstWaveFighterStatisticsEntity extends Auditable {

    @Id
    @GeneratedValue
    private UUID uuid;

    private UUID statisticsUuid;

    @Type(ListArrayType.class)
    private List<String> fighters;

    private Integer gamesEnded;

    private Integer gamesTotal;

    private String patch;

    @Enumerated(EnumType.STRING)
    private GameType gameType;

    @Enumerated(EnumType.STRING)
    private Rank rank;
}
