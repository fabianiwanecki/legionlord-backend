package com.legionlord.legionlordbackend.repository;

import com.legionlord.legionlordbackend.entity.statistics.FirstWaveFighterStatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FirstWaveFightersStatisticsRepository extends JpaRepository<FirstWaveFighterStatisticsEntity, UUID> {
}
