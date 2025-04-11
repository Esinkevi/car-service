package com.example.car_service.service.carService;

import com.example.car_service.dto.CarDTO;
import com.example.car_service.model.Car;
import com.example.car_service.model.Owner;

import java.util.List;

public interface CarService {

    List<Car> findAllCars();

    void createCar(CarDTO carDTO, Owner owner);

    boolean existsByNumberPlate(String numberPlate);

    void deleteById(Long id);

    Car getCarByNumberPlate(String numberPlate);
}
