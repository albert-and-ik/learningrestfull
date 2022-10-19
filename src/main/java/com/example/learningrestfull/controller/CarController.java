package com.example.learningrestfull.controller;

import com.example.learningrestfull.model.StatusCar;
import com.example.learningrestfull.model.dto.CarDto;
import com.example.learningrestfull.model.dto.CarShortDto;
import com.example.learningrestfull.model.dto.NewCarDto;
import com.example.learningrestfull.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CarDto> getById(@PathVariable(value = "uuid") UUID uuid) {
        var dto = carService.getByUuid(uuid);

        return dto == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<CarShortDto>> getAll(){
        var listCars = carService.getAll();

        return new ResponseEntity<>(listCars, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UUID> create(@RequestBody NewCarDto dto) {
        var savedCar =  carService.create(dto);

        return savedCar==null
                ? new ResponseEntity<>(HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(savedCar.getUuid(), HttpStatus.CREATED);
    }

    @RequestMapping(value="/{uuid}", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateStatus(UUID uuid, @RequestParam StatusCar status){
        if (status == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var success = carService.changeStatus(uuid, status);

        return success
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}