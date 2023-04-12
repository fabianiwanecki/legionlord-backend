package com.legionlord.legionlordbackend.entity;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "player_data_mercenaries_received")
public class PlayerDataMercenariesReceivedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Type(ListArrayType.class)
    private List<String> mercenaries;

    private Integer wave;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private GamesPlayerDataEntity playerData;
}

