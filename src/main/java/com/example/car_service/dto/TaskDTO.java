package com.example.car_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private String taskDescription;

    private Integer odometer;

    private double price;

    private String numberPlate;
}
