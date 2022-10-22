package com.example.learningrestfull.service.impl;

import com.example.learningrestfull.mapper.DriverMapper;
import com.example.learningrestfull.model.dto.DriverDto;
import com.example.learningrestfull.model.dto.DriverShortDto;
import com.example.learningrestfull.model.dto.NewDriverDto;
import com.example.learningrestfull.repository.DriverRepository;
import com.example.learningrestfull.service.DriverService;
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
public class DriverServiceImpl implements DriverService {

    final DriverRepository driverRepository;

    @Override
    @Transactional
    public Optional<DriverDto> getByUuid(UUID uuid) {
        return driverRepository
                .findById(uuid)
                .map(DriverMapper.MAPPER::toDto);
    }

    @Override
    @Transactional
    public List<DriverShortDto> getAll() {
        return driverRepository
                .findAll()
                .stream()
                .map(DriverMapper.MAPPER::toShortDto)
                .toList();
    }

    @Override
    @Transactional
    public Page<DriverShortDto> getPage(Pageable pageable) {
        return driverRepository
                .findAll(pageable)
                .map(DriverMapper.MAPPER::toShortDto);
    }


    @Override
    @Transactional
    public UUID create(NewDriverDto driver) {
        return driverRepository
                .save(DriverMapper.MAPPER.toEntity(driver))
                .getUuid();
    }

    @Override
    public void softDelete(UUID uuid) {
        driverRepository.softDelete(uuid);
    }
}
