package com.example.learningrestfull.model.dto;

import com.example.learningrestfull.model.*;
import lombok.Data;

import java.util.UUID;

@Data
public class DriverShortDto {
    UUID uuid;
    String name;
    DrivingLicenseCategory driverLicenseCategory;
}


