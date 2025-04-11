package com.example.car_service.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberPlate;

    private String carBrand;

    private String carModel;

    private String vinCode;

    private String fuelType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
