package com.example.learningrestfull.model.dto;

import com.example.learningrestfull.model.DrivingLicenseCategory;
import lombok.Data;

@Data
public class NewDriverDto {
    String name;
    DrivingLicenseCategory driverLic;
    int age;
}
