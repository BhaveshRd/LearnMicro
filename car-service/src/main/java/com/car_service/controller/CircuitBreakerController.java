package com.car_service.controller;

import com.car_service.model.CarDetail;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    Logger log = LoggerFactory.getLogger(CircuitBreakerController.class);

    //by default retry will happen 3 time with this properties we are setting to 5 retry
    // resilience4j.retry.instances.retry-sampleService.maxAttempts=5

    // setting during for each retry
    //resilience4j.retry.instances.retry_sample_api.waitDuration=5s

    // exponentry increase time for each retry
    //resilience4j.retry.instances.retry_sample_api.enableExponentialBackoff = true
    @GetMapping("sample_api")
    @Retry(name ="retry_sample_api" , fallbackMethod = "fallback")
    @RateLimiter(name = "retry_sample_api")
    public CarDetail getSampleData(){
        log.info("inside get Sample Data --->");
        return new RestTemplate().getForObject("http://localhost:8080/dummy", CarDetail.class);
    }

    public CarDetail fallback(Exception ex){
        return new CarDetail();
    }
}
