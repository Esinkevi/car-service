package com.example.car_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ServiceRecordDTO {


    private String recordDay;

    private String recordTime;

}
