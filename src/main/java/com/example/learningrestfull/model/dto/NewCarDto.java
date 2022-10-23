package com.example.learningrestfull.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
@Schema(description = "Модель для создания автомобиля")
public class NewCarDto {

    @NotBlank
    @Schema(description = "Гос. номер")
    String govNumber;

    @NotNull
    @Schema(description = "Уникальный номер водителя в базе данных")
    UUID owner;

    @NotBlank
    @Schema(description = "Название модели")
    String model;

    @NotBlank
    @Schema(description = "Уникальный номер выданный производителем")
    String vin;

    @Positive
    @Schema(description = "Пробег")
    int mileage;
}
