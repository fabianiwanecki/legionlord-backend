package com.legionlord.legionlordbackend.repository;

import com.legionlord.legionlordbackend.entity.statistics.StatisticsRunEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StatisticsRunRepository extends JpaRepository<StatisticsRunEntity, UUID> {

    StatisticsRunEntity findFirstByOrderByCreateTsDesc();

}
