package com.legionlord.legionlordbackend.repository;

import com.legionlord.legionlordbackend.entity.statistics.StatisticsRunEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StatisticsRunRepository extends JpaRepository<StatisticsRunEntity, UUID> {
}
