package com.example.learningrestfull.service.impl;

import com.example.learningrestfull.model.StatusCar;
import com.example.learningrestfull.model.dto.CarDto;
import com.example.learningrestfull.model.dto.CarShortDto;
import com.example.learningrestfull.model.dto.NewCarDto;
import com.example.learningrestfull.model.entity.CarEntity;
import com.example.learningrestfull.repository.CarRepository;
import com.example.learningrestfull.repository.DriverRepository;
import com.example.learningrestfull.service.CarService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<CarShortDto> getAll() {
        List<CarEntity> carEntities = carRepository.findAll();

        return carEntities
                .stream()
                .map(ce -> modelMapper.map(ce, CarShortDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CarDto> getByUuid(UUID uuid) {
        var carEntityOpt = carRepository.findById(uuid);

        return carEntityOpt.map(carEntity -> modelMapper.map(carEntity, CarDto.class));
    }

    @Override
    public Optional<CarDto> create(NewCarDto car) {

        var ownerOptional = driverRepository.findById(car.getOwner());

        if (ownerOptional.isEmpty()) {
            return Optional.empty();
        }

        var carEntity = modelMapper.map(car, CarEntity.class);

//        carEntity.status = StatusCar.CREATED;
//        carEntity.setCreating(OffsetDateTime.now());
        carEntity.setOwner(ownerOptional.get());

        var carInDb = carRepository.saveAndFlush(carEntity);

        return Optional.of(modelMapper.map(carInDb, CarDto.class));
    }

    @Override
    public boolean changeStatus(UUID uuid, StatusCar status) {
        if (status == StatusCar.CREATED) {
            return false;
        }

        var carEntityOptional = carRepository.findById(uuid);

        carEntityOptional.ifPresent(car -> {
            car.setStatus(status);
            carRepository.saveAndFlush(car);
        });

        return carEntityOptional.isPresent();
    }

}
