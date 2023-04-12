package com.legionlord.legionlordbackend.entity;

import io.hypersistence.utils.hibernate.type.array.IntArrayType;
import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import io.hypersistence.utils.hibernate.type.array.StringArrayType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "games_player_data")
public class GamesPlayerDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String playerId;
    private String playerName;
    private Integer playerSlot;
    private String legion;
    private Integer workers;
    private Integer value;
    @Column(name = "is_cross")
    private Boolean cross;
    private String gameResult;
    private Integer overallElo;
    @Type(ListArrayType.class)
    private List<String> fighters;
    @Type(ListArrayType.class)
    private List<String> mercenaries;
    private Boolean stayedUntilEnd;
    private String chosenSpell;
    private Integer partySize;
    @Type(ListArrayType.class)
    private List<String> firstWaveFighters;
    @Type(ListArrayType.class)
    private List<String> rolls;
    private Integer legionSpecificElo;

    @Type(ListArrayType.class)
    private List<String> partyMembers;
    @Type(ListArrayType.class)
    private List<String> partyMembersIds;
    private Integer mvpScore;
    @Type(IntArrayType.class)
    private Integer[] netWorthPerWave;
    @Type(IntArrayType.class)
    private Integer[] workersPerWave;
    @Type(IntArrayType.class)
    private Integer[] incomePerWave;
    private Integer leakValue;
    private Integer leaksCaughtValue;
    private Integer leftAtSeconds;

    @OneToMany(mappedBy = "playerData", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerDataFightersEntity> buildPerWave;

    @OneToMany(mappedBy = "playerData", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerDataKingUpgradesEntity> kingUpgradesPerWave;

    @OneToMany(mappedBy = "playerData", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerDataKingUpgradesOpponentEntity> opponentKingUpgradesPerWave;

    @OneToMany(mappedBy = "playerData", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerDataLeaksEntity> leaksPerWave;

    @OneToMany(mappedBy = "playerData", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerDataMercenariesReceivedEntity> mercenariesReceivedPerWave;

    @OneToMany(mappedBy = "playerData", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerDataMercenariesSentEntity> mercenariesSentPerWave;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private GameEntity game;
}
