package com.example.car_service.service.recordService;

import com.example.car_service.dto.CarDTO;
import com.example.car_service.dto.OwnerDTO;
import com.example.car_service.dto.ServiceRecordDTO;
import com.example.car_service.dto.TaskDTO;
import com.example.car_service.dto.serviceDTO.ServiceRecordForHomePageDTO;
import com.example.car_service.model.Car;
import com.example.car_service.model.Owner;
import com.example.car_service.model.ServiceRecord;
import com.example.car_service.model.Task;
import com.example.car_service.repositories.ServiceRecordRepository;
import com.example.car_service.service.carService.CarService;
import com.example.car_service.service.ownerService.OwnerService;
import com.example.car_service.service.taskService.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecordServiceImpl implements RecordService {

    private final ServiceRecordRepository serviceRecordRepository;

    private final CarService carService;

    private final OwnerService ownerService;

    private final TaskService taskService;


    @Override
    public boolean ownerExists(String phoneNumber) {
        return ownerService.existsByPhoneNumber(phoneNumber);
    }


    @Override
    public void createOwner(OwnerDTO ownerDTO) {
        ownerService.createOwner(ownerDTO);
        log.info("RecordServiceImpl call createOwner {}", ownerDTO.getName());
    }

    @Override
    public boolean carExist(String numberPlate) {
        return carService.existsByNumberPlate(numberPlate);
    }

    @Override
    public void createCar(String phoneNumber, CarDTO carDTO) {
        Owner owner = ownerService.findOwnerByPhoneNumber(phoneNumber);
        if (owner == null) {
            throw new RuntimeException("Owner not found " + phoneNumber);
        }
        carService.createCar(carDTO, owner);
    }

    @Override
    public void createTask(TaskDTO taskDTO) {
        Car car = carService.getCarByNumberPlate(taskDTO.getNumberPlate());
        taskService.createTask(taskDTO, car);
    }

    @Override
    public void createRecordOnService(ServiceRecordDTO serviceRecordDTO, String phoneNumber, String numberPlate) {
        Car car = carService.getCarByNumberPlate(numberPlate);
        Owner owner = ownerService.findOwnerByPhoneNumber(phoneNumber);
        List<Task> taskList = taskService.findAllTaskByCar(car);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        ServiceRecord serviceRecord = new ServiceRecord();
        serviceRecord.setCar(car);
        serviceRecord.setTaskList(taskList);
        serviceRecord.setOwner(owner);
        serviceRecord.setRecordDay(LocalDate.parse(serviceRecordDTO.getRecordDay(), dateFormatter));
        serviceRecord.setRecordTime(LocalTime.parse(serviceRecordDTO.getRecordTime(), timeFormatter));

        serviceRecordRepository.save(serviceRecord);

    }

    @Override
    public List<ServiceRecordForHomePageDTO> getRecordsForTodayAndTomorrow(LocalDate date) {
        List<ServiceRecord> serviceRecordList = serviceRecordRepository.findAllByRecordDay(date);
        List<ServiceRecordForHomePageDTO> newList = new ArrayList<>();
        for (ServiceRecord serviceRecord : serviceRecordList) {

            ServiceRecordForHomePageDTO serviceDto = new ServiceRecordForHomePageDTO();
            serviceDto.setRecordTime(serviceRecord.getRecordTime());
            serviceDto.setRecordDate(serviceRecord.getRecordDay());
            serviceDto.setOwnerName(serviceRecord.getOwner().getName());
            serviceDto.setOwnerLastName(serviceRecord.getOwner().getLastName());
            serviceDto.setCarBrand(serviceRecord.getCar().getCarBrand());
            serviceDto.setCarModel(serviceRecord.getCar().getCarModel());

            StringBuilder stringBuilder = new StringBuilder();
            for (Task task : serviceRecord.getTaskList()) {
                stringBuilder.append(task.getTaskDescription());
                stringBuilder.append(" ");
            }

            serviceDto.setTaskDescription(String.valueOf(stringBuilder));

            newList.add(serviceDto);

        }

        return newList;
    }


}
