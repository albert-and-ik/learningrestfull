package com.example.learningrestfull.service.impl;

import com.example.learningrestfull.model.dto.DriverDto;
import com.example.learningrestfull.model.dto.DriverShortDto;
import com.example.learningrestfull.model.dto.NewDriverDto;
import com.example.learningrestfull.model.entity.DriverEntity;
import com.example.learningrestfull.repository.DriverRepository;
import com.example.learningrestfull.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<DriverShortDto> getAll() {
        return driverRepository
                .findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, DriverShortDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DriverDto> getByUuid(UUID uuid) {
        return driverRepository
                .findById(uuid)
                .map(e->modelMapper.map(e,DriverDto.class));
    }

    @Override
    public Optional<DriverDto> create(NewDriverDto driver) {
        var driverEntity = modelMapper.map(driver, DriverEntity.class);

        driverEntity.setUuid(UUID.randomUUID());
        driverEntity.setCreating(OffsetDateTime.now());

        var driverInDb = driverRepository.saveAndFlush(driverEntity);

        return Optional.ofNullable(modelMapper.map(driverInDb, DriverDto.class));
    }
}
