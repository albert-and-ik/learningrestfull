package com.example.learningrestfull.model.dto;

import com.example.learningrestfull.model.DrivingLicenseCategory;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
public class NewDriverDto {
    @NotNull
    @Length(min = 2, max = 256)
    @NotBlank
    String name;

    @NotNull
    DrivingLicenseCategory driverLicenseCategory;

    @Min(16)
    @NotNull
    int age;
}
