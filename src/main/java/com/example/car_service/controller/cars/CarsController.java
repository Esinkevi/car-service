package com.example.car_service.controller.cars;

import com.example.car_service.model.Car;
import com.example.car_service.service.carService.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarsController {

    private final CarService carService;

    @GetMapping
    public String getAllCars(Model model){
        List<Car> cars = carService.findAllCars();
        model.addAttribute("cars", cars);
        return "cars-list";
    }
    @PostMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id){
        carService.deleteById(id);
        return "redirect:/cars";
    }
}
