package com.example.learningrestfull.service.impl;

import com.example.learningrestfull.model.StatusCar;
import com.example.learningrestfull.model.dto.CarDto;
import com.example.learningrestfull.model.dto.CarShortDto;
import com.example.learningrestfull.model.dto.NewCarDto;
import com.example.learningrestfull.model.entity.CarEntity;
import com.example.learningrestfull.repository.CarReposiroty;
import com.example.learningrestfull.service.CarService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    @Autowired
    CarReposiroty carReposiroty;


    @Override
    public List<CarShortDto> getAll() {
        List<CarEntity> carEntities =  carReposiroty.findAll();

        return carEntities
                .stream()
                .map(ce -> modelMapper().map(ce,CarShortDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CarDto getByUuid(UUID uuid) {
        try {
            CarEntity carEntity = carReposiroty.getReferenceById(uuid);

            return modelMapper().map(carEntity, CarDto.class);

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public CarDto create(NewCarDto car) {
        var carEntity =  modelMapper().map(car, CarEntity.class);
        carEntity.setUuid(UUID.randomUUID());

        var carInDb =  carReposiroty.saveAndFlush(carEntity);

        return modelMapper().map(carInDb, CarDto.class);
    }

    @Override
    public boolean changeStatus(UUID uuid, StatusCar status) {

        try {
            var carEntity = carReposiroty.getReferenceById(uuid);

            carEntity.setStatus(status);

            carReposiroty.saveAndFlush(carEntity);

            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Bean
    private ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
