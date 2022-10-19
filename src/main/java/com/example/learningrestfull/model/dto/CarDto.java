package com.example.learningrestfull.model.dto;

import com.example.learningrestfull.model.StatusCar;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class CarDto extends CarShortDto {
    String govNumber;
    int mileage;
    StatusCar status;
    DriverShortDto owner;
    OffsetDateTime creating;
}
