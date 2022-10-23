package com.example.learningrestfull.model.dto;

import com.example.learningrestfull.model.DrivingCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Модель для создание водителя")
public class NewDriverDto {

    @Length(min = 2, max = 256)
    @NotBlank
    @Schema(description = "ФИО")
    String name;

    @NotNull
    @Schema(description = "Категория прав")
    DrivingCategory driverCategory;

    @Min(18)
    @Schema(description = "Возраст")
    int age;
}
