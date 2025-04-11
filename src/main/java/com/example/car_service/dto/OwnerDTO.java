package com.example.car_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDTO {

    private String name;
    private String lastName;
    private String phoneNumber;
}
