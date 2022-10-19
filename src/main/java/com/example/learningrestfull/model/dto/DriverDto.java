package com.example.learningrestfull.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class DriverDto extends DriverShortDto {
    int age;
    List<CarDto> cars;
    OffsetDateTime creating;
}
