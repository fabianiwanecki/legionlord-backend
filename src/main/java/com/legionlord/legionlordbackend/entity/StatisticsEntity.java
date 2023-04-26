package com.legionlord.legionlordbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StatisticsEntity {

    @Id
    private String id;

    private Integer wins;

    private Integer total;
}
