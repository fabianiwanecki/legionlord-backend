package com.legionlord.legionlordbackend.repository;

import com.legionlord.legionlordbackend.entity.statistics.EndingWaveStatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EndingWaveStatisticsRepository extends JpaRepository<EndingWaveStatisticsEntity, UUID> {
}
