package com.example.car_service.model.repositories;

import com.example.car_service.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {


    boolean existsByNumberPlate(String numberPlate);

    Car findByNumberPlate(String numberPlate);
}
