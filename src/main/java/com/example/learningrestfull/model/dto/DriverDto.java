package com.example.learningrestfull.model.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class DriverDto extends DriverShortDto {
    public int age;
    public List<CarDto> cars;
    public OffsetDateTime creating;
}
