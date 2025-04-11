package com.example.car_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String phoneNumber;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Car> cars;

}
