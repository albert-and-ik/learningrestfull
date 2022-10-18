package com.example.learningrestfull.model.dto;

import com.example.learningrestfull.model.StatusCar;

import java.time.OffsetDateTime;

public class CarDto extends CarShortDto {
    public String govNumber;
    public int mileage;
    public StatusCar status;
    public DriverShortDto owner;
    public OffsetDateTime creating;
}
