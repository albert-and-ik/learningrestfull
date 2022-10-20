package com.example.learningrestfull.service;

import com.example.learningrestfull.model.dto.DriverDto;
import com.example.learningrestfull.model.dto.DriverShortDto;
import com.example.learningrestfull.model.dto.NewDriverDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface DriverService {
    List<DriverShortDto> getAll();

    Optional<DriverDto> getByUuid(UUID uuid);

    Optional<DriverDto> create(NewDriverDto driver);
}
