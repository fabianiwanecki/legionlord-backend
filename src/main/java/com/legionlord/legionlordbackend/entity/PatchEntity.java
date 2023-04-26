package com.legionlord.legionlordbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "patches")
public class PatchEntity extends Auditable {

    @Id
    private String patch;

}
