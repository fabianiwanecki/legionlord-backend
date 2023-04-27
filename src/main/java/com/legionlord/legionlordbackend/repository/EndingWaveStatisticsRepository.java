package com.legionlord.legionlordbackend.repository;

import com.legionlord.legionlordbackend.entity.GameType;
import com.legionlord.legionlordbackend.entity.Rank;
import com.legionlord.legionlordbackend.entity.statistics.EndingWaveStatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EndingWaveStatisticsRepository extends JpaRepository<EndingWaveStatisticsEntity, UUID> {

    List<EndingWaveStatisticsEntity> findAllByStatisticsUuidAndRankAndGameType(UUID statisticsUuid, Rank rank, GameType gameType);
}
