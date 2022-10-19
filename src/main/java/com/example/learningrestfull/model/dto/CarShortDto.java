package com.example.learningrestfull.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CarShortDto {
    UUID uuid;
    String model;
    String VIN;
}
