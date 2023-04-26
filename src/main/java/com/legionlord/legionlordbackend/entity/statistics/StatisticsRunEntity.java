package com.legionlord.legionlordbackend.entity.statistics;

import com.legionlord.legionlordbackend.entity.Auditable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "statistics")
public class StatisticsRunEntity extends Auditable {

    @Id
    @GeneratedValue
    private UUID uuid;

    private String patch;
}
