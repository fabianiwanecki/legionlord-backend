package com.legionlord.legionlordbackend.repository;

import com.legionlord.legionlordbackend.entity.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<UnitEntity, String> {
}
