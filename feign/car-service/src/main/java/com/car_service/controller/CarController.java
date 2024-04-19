package com.car_service.controller;

import com.car_service.model.CarDetail;
import com.car_service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/car_service")
public class CarController {


    @Autowired
    CarService service;

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CarDetail getCarDetail(@PathVariable String name){

        return service.getDetailsByBrand(name);

    }
}
