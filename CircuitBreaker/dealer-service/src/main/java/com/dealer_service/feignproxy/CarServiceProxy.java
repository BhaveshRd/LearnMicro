package com.dealer_service.feignproxy;


import com.dealer_service.model.CarDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name = "car-service", url = "http://localhost:8000/car_service")

// removing url will not invoke automatic load balancing
//the Feign client to talk to Eureka and pick up the instances of car service
//and do load balancing between them.
@FeignClient(name = "car-service")
public interface CarServiceProxy {

    @GetMapping(value = "/car_service/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    CarDetail getCarDetail(@PathVariable String name);



}
