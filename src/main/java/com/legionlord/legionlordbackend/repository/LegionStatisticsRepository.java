package com.legionlord.legionlordbackend.repository;

import com.legionlord.legionlordbackend.entity.GameType;
import com.legionlord.legionlordbackend.entity.Rank;
import com.legionlord.legionlordbackend.entity.statistics.LegionStatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LegionStatisticsRepository extends JpaRepository<LegionStatisticsEntity, UUID> {
    List<LegionStatisticsEntity> findAllByStatisticsUuidAndRankAndGameType(UUID uuid, Rank rank, GameType gameType);
}
