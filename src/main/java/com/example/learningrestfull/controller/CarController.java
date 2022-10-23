package com.example.learningrestfull.controller;

import com.example.learningrestfull.model.CarStatus;
import com.example.learningrestfull.model.dto.CarDto;
import com.example.learningrestfull.model.dto.CarShortDto;
import com.example.learningrestfull.model.dto.NewCarDto;
import com.example.learningrestfull.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "Автомобили", description = "API для работы с атомобилями")
@RestController
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {
    final CarService carService;

    @GetMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получение автомобиля по UUID",
            description = "Получение автомобиля по уникальному номер UUID",
            tags = {"Автомобили"})
    public CarDto getById(
            @Parameter(description = "Уникальный номер автомобиля в базе данных")
            @PathVariable(value = "uuid")
            UUID uuid
    ) {
        return carService
                .getByUuid(uuid)
                .orElseThrow();
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить весь список автомобилей",
            description = "Возращает весь список автомобилей хранящийся в базе",
            tags = {"Автомобили"})
    public List<CarShortDto> getAll() {
        return carService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создание автомобиля",
            description = "Запись автомобиля в базу данных",
            responses = {@ApiResponse(description = "Уникальный номер созданного автомобиля")},
            tags = {"Автомобили"})
    public UUID create(
            @RequestBody
            @Valid
            @Parameter(description = "Модель для записи автомобиля")
            NewCarDto dto
    ) {
        return carService.create(dto);
    }

    @PatchMapping("/{uuid}")
    @Operation(summary = "Обновить статус автомобиля",
            description = "Обновить статус автомобиля в базе данных",
            responses = {@ApiResponse(description = "Если успешно true, иначе false")},
            tags = {"Автомобили"})
    public boolean updateStatus(
            @PathVariable
            @Parameter(description = "Уникальный номер в базе данных")
            UUID uuid,
            @RequestParam
            @Parameter(description = "Новый статус")
            CarStatus status
    ) {
        return carService.changeStatus(uuid, status);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удаление автомобиля по UUID",
            description = "Удаление автомобиля у которого совпадает UUID",
            tags = {"Автомобили"})
    public HttpStatus softDelete(
            @PathVariable
            @Parameter(description = "Уникальный номер автомобиля")
            UUID uuid
    ) {
        carService.softDelete(uuid);
        return HttpStatus.NO_CONTENT;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить часть списка",
            description = "Получение страницы из всего спика",
            tags = {"Автомобили"})
    public Page<CarShortDto> getPage(
            @RequestParam(defaultValue = "0")
            @Parameter(description = "Страница")
            int page,
            @RequestParam(defaultValue = "10")
            @Parameter(description = "Количество записей на странице")
            int size,
            @RequestParam(defaultValue = "name")
            @Parameter(description = "Сортироват по полю")
            String sortBy

    ) {
        return carService.getPage(PageRequest.of(page, size, Sort.by(sortBy)));
    }
}