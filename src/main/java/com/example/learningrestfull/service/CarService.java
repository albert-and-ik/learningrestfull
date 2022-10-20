package com.example.learningrestfull.service;

import com.example.learningrestfull.model.StatusCar;
import com.example.learningrestfull.model.dto.CarDto;
import com.example.learningrestfull.model.dto.CarShortDto;
import com.example.learningrestfull.model.dto.NewCarDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface CarService {

    List<CarShortDto> getAll();
    Optional<CarDto> getByUuid(UUID uuid);

    Optional<CarDto> create(NewCarDto car);

    boolean changeStatus(UUID uuid, StatusCar status);
}
