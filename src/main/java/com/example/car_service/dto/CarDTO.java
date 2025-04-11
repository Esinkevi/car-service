package com.example.car_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private String numberPlate;
    private String carBrand;
    private String carModel;
    private String vinCode;
    private String fuelType;
}