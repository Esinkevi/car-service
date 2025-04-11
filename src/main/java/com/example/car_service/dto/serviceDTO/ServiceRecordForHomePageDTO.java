package com.example.car_service.dto.serviceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRecordForHomePageDTO {

    private LocalDate recordDate;

    private LocalTime recordTime;

    private String ownerName;

    private String ownerLastName;

    private String carBrand;

    private String carModel;

    private String taskDescription;

}
