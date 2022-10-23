package com.example.learningrestfull.model.dto;

import com.example.learningrestfull.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
@Schema(description = "Сокращенное представление водителя")
public class DriverShortDto {

    @Schema(description = "Уникальный номер водителя в базе данных")
    UUID uuid;

    @Schema(description = "ФИО водителя")
    String name;

    @Schema(description = "Категория прав")
    DrivingCategory driverCategory;
}


