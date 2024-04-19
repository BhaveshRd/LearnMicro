package com.dealer_service.feignproxy;


import com.dealer_service.model.CarDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "car-service", url = "http://localhost:8000/car_service")
public interface CarServiceProxy {

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    CarDetail getCarDetail(@PathVariable String name);



}
