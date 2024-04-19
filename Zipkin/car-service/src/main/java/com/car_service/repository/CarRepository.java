package com.car_service.repository;

import com.car_service.model.CarDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarDetail, Integer> {

    Optional<CarDetail> findByBrand(String name);

}
