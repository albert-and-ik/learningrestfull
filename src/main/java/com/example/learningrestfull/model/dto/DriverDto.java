package com.example.learningrestfull.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Полное представление водителя")
public class DriverDto extends DriverShortDto {

    @Schema(description = "Возраст")
    int age;

    @Schema(description = "Автомобили")
    List<CarShortDto> cars;

    @Schema(description = "Дата записи в базу данных")
    OffsetDateTime createdAt;

}
