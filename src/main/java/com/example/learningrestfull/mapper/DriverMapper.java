package com.example.learningrestfull.mapper;

import com.example.learningrestfull.model.dto.DriverDto;
import com.example.learningrestfull.model.dto.DriverShortDto;
import com.example.learningrestfull.model.dto.NewDriverDto;
import com.example.learningrestfull.model.entity.DriverEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    DriverMapper MAPPER = Mappers.getMapper(DriverMapper.class);

    DriverEntity toEntity(NewDriverDto newDriverDto);

    DriverShortDto toShortDto(DriverEntity driverEntity);

    DriverDto toDto(DriverEntity driverEntity);
}
