package com.legionlord.legionlordbackend.repository;

import com.legionlord.legionlordbackend.entity.statistics.RollStatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RollStatisticsRepository extends JpaRepository<RollStatisticsEntity, UUID> {
}
