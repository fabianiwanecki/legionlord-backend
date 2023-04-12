package com.legionlord.legionlordbackend.repository;

import com.legionlord.legionlordbackend.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, String> {
}
