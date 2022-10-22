package com.example.learningrestfull.service;

import com.example.learningrestfull.model.CarStatus;
import com.example.learningrestfull.model.dto.CarDto;
import com.example.learningrestfull.model.dto.CarShortDto;
import com.example.learningrestfull.model.dto.NewCarDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface CarService {
    List<CarShortDto> getAll();
    Page<CarShortDto> getPage(Pageable pageable);
    Optional<CarDto> getByUuid(UUID uuid);

    UUID create(NewCarDto car);

    boolean changeStatus(UUID uuid, CarStatus status);

    void softDelete(UUID uuid);
}
