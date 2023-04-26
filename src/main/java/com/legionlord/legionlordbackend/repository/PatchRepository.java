package com.legionlord.legionlordbackend.repository;

import com.legionlord.legionlordbackend.entity.PatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatchRepository extends JpaRepository<PatchEntity, String> {
    Optional<PatchEntity> findFirstByOrderByCreateTsDesc();
}
