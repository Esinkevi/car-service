package com.example.car_service.mapper;

import com.example.car_service.dto.reportsDTO.ResultsForPeriodDTO;
import com.example.car_service.model.ServiceRecord;
import com.example.car_service.model.Task;

public class ResultsForPeriodMapper {

    public static ResultsForPeriodDTO toDTO(ServiceRecord record) {
        ResultsForPeriodDTO dto = new ResultsForPeriodDTO();

        // Собираем описание задач
        StringBuilder descriptionBuilder = new StringBuilder();
        double totalPrice = 0.0;

        for (Task task : record.getTaskList()) {
            descriptionBuilder.append(task.getTaskDescription()).append(" ");
            totalPrice += task.getPrice();
        }

        dto.setTaskDescription(descriptionBuilder.toString().trim());
        dto.setPrice(totalPrice);

        dto.setCarBrand(record.getCar().getCarBrand());
        dto.setCarModel(record.getCar().getCarModel());
        dto.setOwnerName(record.getOwner().getName());

        return dto;
    }
}
