package com.example.learningrestfull.repository;

import com.example.learningrestfull.model.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarReposiroty extends JpaRepository<DriverEntity, UUID> {
}
