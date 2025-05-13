package com.example.car_service.mapper;

import com.example.car_service.dto.CarDTO;
import com.example.car_service.model.Car;

public class CarMapper {

    public static CarDTO toDTO(Car car) {
        CarDTO dto = new CarDTO();
        dto.setNumberPlate(car.getNumberPlate());
        dto.setCarBrand(car.getCarBrand());
        dto.setCarModel(car.getCarModel());
        dto.setVinCode(car.getVinCode());
        dto.setFuelType(car.getFuelType());
        return dto;
    }

    public static Car toEntity(CarDTO dto) {
        Car car = new Car();
        car.setNumberPlate(dto.getNumberPlate());
        car.setCarBrand(dto.getCarBrand());
        car.setCarModel(dto.getCarModel());
        car.setVinCode(dto.getVinCode());
        car.setFuelType(dto.getFuelType());
        return car;
    }
}
