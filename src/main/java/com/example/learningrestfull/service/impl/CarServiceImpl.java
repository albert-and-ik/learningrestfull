package com.example.learningrestfull.service.impl;

import com.example.learningrestfull.mapper.CarMapper;
import com.example.learningrestfull.model.CarStatus;
import com.example.learningrestfull.model.dto.CarDto;
import com.example.learningrestfull.model.dto.CarShortDto;
import com.example.learningrestfull.model.dto.NewCarDto;
import com.example.learningrestfull.model.entity.DriverEntity;
import com.example.learningrestfull.repository.CarRepository;
import com.example.learningrestfull.repository.DriverRepository;
import com.example.learningrestfull.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    final CarRepository carRepository;
    final DriverRepository driverRepository;

    @Override
    @Transactional
    public List<CarShortDto> getAll() {
        return carRepository
                .findAll()
                .stream()
                .map(CarMapper.MAPPER::toShortDto)
                .toList();
    }

    @Override
    @Transactional
    public Page<CarShortDto> getPage(Pageable pageable) {
        return carRepository
                .findAll(pageable)
                .map(CarMapper.MAPPER::toShortDto);
    }

    @Override
    @Transactional
    public Optional<CarDto> getByUuid(UUID uuid) {
        return carRepository
                .findById(uuid)
                .map(CarMapper.MAPPER::toDto);
    }

    @Override
    @Transactional
    public UUID create(NewCarDto car) {

        var carEntity = CarMapper.MAPPER.toEntity(car);

        var owner = new DriverEntity();
        owner.setUuid(car.getOwner());

        carEntity.setOwner(owner);

        return carRepository
                .save(carEntity)
                .getUuid();
    }

    @Override
    @Transactional
    public boolean changeStatus(UUID uuid, CarStatus status) {
        if(status == CarStatus.CREATED) {
            return false;
        }

        carRepository
                .findById(uuid)
                .ifPresent(car -> {
                    car.setStatus(status);
                    carRepository.saveAndFlush(car);
                });

        return true;
    }

    @Override
    public void softDelete(UUID uuid) {
        carRepository.softDelete(uuid);
    }


}
