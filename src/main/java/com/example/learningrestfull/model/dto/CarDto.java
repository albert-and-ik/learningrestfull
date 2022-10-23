package com.example.learningrestfull.model.dto;

import com.example.learningrestfull.model.CarStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Полное представление автомобиля")
public class CarDto extends CarShortDto {

    @Schema(description = "Государственный номер автомобиля")
    String govNumber;

    @Schema(description = "Пробег")
    int mileage;

    @Schema(description = "Статус автомобиля")
    CarStatus status;

    @Schema(description = "Владелец")
    DriverShortDto owner;


    @Schema(description = "Дата и время регистрации а базе данных")
    OffsetDateTime createdAt;
}
