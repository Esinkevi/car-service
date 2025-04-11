package com.example.car_service.service.recordService;

import com.example.car_service.dto.CarDTO;
import com.example.car_service.dto.OwnerDTO;
import com.example.car_service.dto.ServiceRecordDTO;
import com.example.car_service.dto.TaskDTO;
import com.example.car_service.dto.serviceDTO.ServiceRecordForHomePageDTO;

import java.time.LocalDate;
import java.util.List;


public interface RecordService {



    boolean ownerExists(String phoneNumber);

    void createOwner(OwnerDTO ownerDTO);

    boolean carExist(String numberPlate);


    void createCar(String phoneNumber, CarDTO carDTO);

    void createTask(TaskDTO taskDTO);

    void createRecordOnService(ServiceRecordDTO serviceRecordDTO, String phoneNumber, String numberPlate);

    List<ServiceRecordForHomePageDTO> getRecordsForTodayAndTomorrow(LocalDate date);

}
