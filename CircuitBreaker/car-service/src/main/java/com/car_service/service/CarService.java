package com.car_service.service;

import com.car_service.model.CarDetail;
import com.car_service.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    CarRepository repository;

    public CarDetail getDetailsByBrand(String name){

        return repository.findByBrand(name).orElse(new CarDetail());

    }
}
