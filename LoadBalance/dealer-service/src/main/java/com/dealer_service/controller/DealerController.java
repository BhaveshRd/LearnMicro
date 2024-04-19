package com.dealer_service.controller;

import com.dealer_service.feignproxy.CarServiceProxy;
import com.dealer_service.model.CarDetail;
import com.dealer_service.model.CardInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("/dealer")
public class DealerController {

    @Autowired
    CarServiceProxy carServiceProxy;

    @GetMapping("/info/brand/{brand}/quantity/{quantity}")
    public CardInfoResponse getCardInfo(@PathVariable String brand,
                                        @PathVariable BigDecimal quantity){


        HashMap<String, String> uriVariable =new HashMap<>();
        uriVariable.put("name", brand);

        ResponseEntity<CarDetail> forEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/car_service/{name}",
                CarDetail.class,
                uriVariable);


        CarDetail carDetail = forEntity.getBody();

        return new CardInfoResponse.CardInfoResponseBuilder()
                .setBrand(carDetail.getBrand())
                .setModel(carDetail.getModel())
                .setQuantity(quantity)
                .setPerUnit(carDetail.getPrice())
                .setTotal(quantity.multiply(carDetail.getPrice()))
                .setEnvironment(carDetail.getEnvironment())
                .build();


    }


    @GetMapping("/info_feign/brand/{brand}/quantity/{quantity}")
    public CardInfoResponse getCardInfoUsingFeign(@PathVariable String brand,
                                        @PathVariable BigDecimal quantity){

        CarDetail carDetail = carServiceProxy.getCarDetail(brand);

        return new CardInfoResponse.CardInfoResponseBuilder()
                .setBrand(carDetail.getBrand())
                .setModel(carDetail.getModel())
                .setQuantity(quantity)
                .setPerUnit(carDetail.getPrice())
                .setTotal(quantity.multiply(carDetail.getPrice()))
                .setEnvironment(carDetail.getEnvironment())
                .build();


    }
}
