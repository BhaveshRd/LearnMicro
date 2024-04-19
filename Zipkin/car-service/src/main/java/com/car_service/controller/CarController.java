package com.car_service.controller;

import com.car_service.model.CarDetail;
import com.car_service.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
    Environment env;

    @Autowired
    CarService service;

    Logger log = LoggerFactory.getLogger(CarController.class);

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CarDetail getCarDetail(@PathVariable String name){

        log.info("inside getCarDetail--> "+name);
        //Only because of zipkin id is assign to each request.
        //2024-04-18T14:02:39.630+05:30
        // INFO [car-service,1ed4372f2e1f832c03042d5eee0bff44,169f73df719bea06]
        // 55132 --- [car-service]
        // [nio-8000-exec-2] [1ed4372f2e1f832c03042d5eee0bff44-169f73df719bea06]
        // c.car_service.controller.CarController   : inside getCarDetail--> ford
        CarDetail detailsByBrand = service.getDetailsByBrand(name);
        detailsByBrand.setEnvironment( env.getProperty("local.server.port"));

        return detailsByBrand;

    }
}
