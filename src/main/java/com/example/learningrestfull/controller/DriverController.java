package com.example.learningrestfull.controller;

import com.example.learningrestfull.model.dto.DriverDto;
import com.example.learningrestfull.model.dto.DriverShortDto;
import com.example.learningrestfull.model.dto.NewDriverDto;
import com.example.learningrestfull.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    DriverService driverService;

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<DriverDto> getById(@PathVariable(value = "uuid") String uuid) {
        var dto = driverService.getByUuid(UUID.fromString(uuid));

        return dto.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(dto.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<DriverShortDto>> getAll(){
        var listDrivers = driverService.getAll();

        return new ResponseEntity<>(listDrivers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UUID> create(@RequestBody @Valid NewDriverDto dto) {
        var savedDriver =  driverService.create(dto);

        var uuid = savedDriver.map(DriverDto::getUuid);

        return uuid.isEmpty()
                ? new ResponseEntity<>(HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(uuid.get(), HttpStatus.CREATED);
    }
}