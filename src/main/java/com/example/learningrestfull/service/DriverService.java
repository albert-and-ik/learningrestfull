package com.example.learningrestfull.service;

import com.example.learningrestfull.model.dto.DriverDto;
import com.example.learningrestfull.model.dto.DriverShortDto;
import com.example.learningrestfull.model.dto.NewDriverDto;

import java.util.List;
import java.util.UUID;

public interface DriverService {
    List<DriverShortDto> getAll();

    DriverDto getByUuid(UUID uuid);

    DriverDto create(NewDriverDto driver);
}
