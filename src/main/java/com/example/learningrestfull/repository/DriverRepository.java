package com.example.learningrestfull.repository;

import com.example.learningrestfull.model.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DriverRepository extends JpaRepository<DriverEntity, UUID> {
    @Override
    Optional<DriverEntity> findById(UUID uuid);
}
