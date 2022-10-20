package com.example.learningrestfull.model.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class NewCarDto {
    @NotNull
    @NotBlank
    String govNumber;

    @NotNull
    UUID owner;

    @NotNull
    @NotBlank
    String model;

    @NotNull
    @NotBlank
    String vin;

    @NotNull
    @Min(0)
    int mileage;
}
