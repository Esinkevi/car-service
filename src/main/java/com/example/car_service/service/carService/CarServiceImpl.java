package com.example.car_service.service.carService;

import com.example.car_service.dto.CarDTO;
import com.example.car_service.model.Car;
import com.example.car_service.model.Owner;
import com.example.car_service.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;


    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void createCar(CarDTO carDTO, Owner owner) {
        Car car = new Car();
        car.setNumberPlate(carDTO.getNumberPlate());
        car.setCarModel(carDTO.getCarModel());
        car.setCarBrand(carDTO.getCarBrand());
        car.setVinCode(carDTO.getVinCode());
        car.setOwner(owner);
        car.setFuelType(carDTO.getFuelType());
        carRepository.save(car);
    }

    @Override
    public boolean existsByNumberPlate(String numberPlate) {
        return carRepository.existsByNumberPlate(numberPlate);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car getCarByNumberPlate(String numberPlate) {
        return carRepository.findByNumberPlate(numberPlate);
    }
}
