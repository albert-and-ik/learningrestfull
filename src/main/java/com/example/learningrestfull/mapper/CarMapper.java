package com.example.learningrestfull.mapper;

import com.example.learningrestfull.model.dto.CarDto;
import com.example.learningrestfull.model.dto.CarShortDto;
import com.example.learningrestfull.model.dto.NewCarDto;
import com.example.learningrestfull.model.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        uses = {DriverMapper.class})
public interface CarMapper {

    CarMapper MAPPER = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "owner.uuid", source = "owner")
    CarEntity toEntity(NewCarDto newCarDto);

    CarShortDto toShortDto(CarEntity car);

    @Mapping(target = "owner.uuid", source = "owner.uuid")
    CarDto toDto(CarEntity car);
}
