package com.example.learningrestfull.service;

import com.example.learningrestfull.model.dto.DriverDto;
import com.example.learningrestfull.model.dto.DriverShortDto;
import com.example.learningrestfull.model.dto.NewDriverDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface DriverService {
    List<DriverShortDto> getAll();
    Page<DriverShortDto> getPage(Pageable pageable);

    Optional<DriverDto> getByUuid(UUID uuid);

    UUID create(NewDriverDto driver);

    void softDelete(UUID uuid);

}