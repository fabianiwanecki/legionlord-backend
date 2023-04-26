package com.legionlord.legionlordbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "units")
public class UnitEntity {

    @Id
    private String id;

    private String unitId;

    private String name;

    private String iconPath;

    private Integer cost;

    private Boolean enabled;
}
