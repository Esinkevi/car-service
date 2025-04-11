package com.example.car_service.service.taskService;

import com.example.car_service.dto.TaskDTO;
import com.example.car_service.model.Car;
import com.example.car_service.model.ServiceRecord;
import com.example.car_service.model.Task;

import java.util.List;

public interface TaskService {

    void createTask(TaskDTO taskDTO, Car car);

    Task getTaskByCar(Car car);

    List<Task> findAllTaskByCar(Car car);
}
