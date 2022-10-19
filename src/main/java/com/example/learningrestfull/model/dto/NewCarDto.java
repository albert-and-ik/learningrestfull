package com.example.learningrestfull.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class NewCarDto {
    String govNumber;
    UUID owner;
    String model;
    String vin;
    int mileage;
}
