package com.example.learningrestfull.service;

import com.example.learningrestfull.model.StatusCar;
import com.example.learningrestfull.model.dto.CarDto;
import com.example.learningrestfull.model.dto.CarShortDto;
import com.example.learningrestfull.model.dto.NewCarDto;

import java.util.List;
import java.util.UUID;

public interface CarService {

    List<CarShortDto> getAll();
    CarDto getByUuid(UUID uuid);

    CarDto create(NewCarDto car);

    boolean changeStatus(UUID uuid, StatusCar status);
}
