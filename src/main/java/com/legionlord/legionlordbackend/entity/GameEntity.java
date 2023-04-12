package com.legionlord.legionlordbackend.entity;

import io.hypersistence.utils.hibernate.type.array.DoubleArrayType;
import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import io.hypersistence.utils.hibernate.type.array.StringArrayType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "games")
public class GameEntity {

    @Id
    private String id;

    @Column(name = "patch_version")
    private String version;
    private ZonedDateTime date;
    private String queueType;
    private Integer endingWave;
    private Long gameLength;
    private Integer gameElo;
    private Integer playerCount;

    @Type(ListArrayType.class)
    private List<String> spellChoices;

    @Type(ListArrayType.class)
    private List<Double> leftKingPercentHp;

    @Type(ListArrayType.class)
    private List<Double> rightKingPercentHp;

    private String kingSpell;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GamesPlayerDataEntity> playersData;
}
