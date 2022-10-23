package com.example.learningrestfull.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
@Schema(description = "Сокращенное представление автомобиля")
public class CarShortDto {
    @Schema(description = "Уникальный номер в базе данных")
    UUID uuid;

    @Schema(description = "Название модели")
    String model;

    @Schema(description = "Уникальный номер выданный производителем")
    String vin;
}
