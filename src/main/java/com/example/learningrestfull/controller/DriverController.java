package com.example.learningrestfull.controller;

import com.example.learningrestfull.model.dto.DriverDto;
import com.example.learningrestfull.model.dto.DriverShortDto;
import com.example.learningrestfull.model.dto.NewDriverDto;
import com.example.learningrestfull.service.DriverService;
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


@RestController
@RequestMapping("/drivers")
@AllArgsConstructor
@Tag(name = "Водители",  description = "API для работы с водителями")
public class DriverController {
    final DriverService driverService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить часть списка",
            description = "Получение страницы из всего спика",
            tags = {"Водители"})
    public Page<DriverShortDto> getPage(
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
        return driverService.getPage(PageRequest.of(page, size, Sort.by(sortBy)));
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Список всех водителей",
            description = "Возращает весь список водителей хранящийся в базе",
            tags = {"Водители"})
    public List<DriverShortDto> getAll() {
        return driverService.getAll();
    }

    @GetMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Поиск водителя по UUID",
            description = "Поиск в базе данных водителя у которого совпадает UUID",
            tags = {"Водители"})
    public DriverDto getById(
            @PathVariable
            @Parameter(description = "Уникальный идентификацоинный ID", required = true)
            UUID uuid
    ) {
        return driverService
                .getByUuid(uuid)
                .orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создание водителя",
            description = "Запись водителя в базу данных",
            responses = {@ApiResponse(description = "Уникальный номер созданного водителя")},
            tags = {"Водители"})
    public UUID create(
            @RequestBody
            @Valid
            @Parameter(description = "Представление водителя")
            NewDriverDto dto
    ) {
        return driverService.create(dto);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удаление водителя по UUID",
            description = "Удаление водителя у которого совпадает UUID",
            tags = {"Водители"})
    public HttpStatus softDelete(
            @PathVariable
            @Parameter(description = "Уникальный номер водителя")
            UUID uuid
    ) {
        driverService.softDelete(uuid);
        return HttpStatus.NO_CONTENT;
    }
}