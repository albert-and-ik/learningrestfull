package com.example.learningrestfull.repository;

import com.example.learningrestfull.model.entity.CarEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarRepository extends JpaRepository<CarEntity, UUID> {
    @Override
    Optional<CarEntity> findById(UUID uuid);
}
