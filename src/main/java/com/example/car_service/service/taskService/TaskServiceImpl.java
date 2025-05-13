package com.example.car_service.service.taskService;

import com.example.car_service.dto.TaskDTO;
import com.example.car_service.model.Car;
import com.example.car_service.model.Task;
import com.example.car_service.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public void createTask(TaskDTO taskDTO, Car car) {
        Task task = new Task();
        task.setTaskDescription(taskDTO.getTaskDescription());
        task.setCar(car);
        task.setPrice(taskDTO.getPrice());
        task.setOdometer(taskDTO.getOdometer());
        taskRepository.save(task);
    }

    @Override
    public Task getTaskByCar(Car car) {
        return taskRepository.findByCar(car);

    }

    @Override
    public List<Task> findAllTaskByCar(Car car) {
        return taskRepository.findAllByCar(car);
    }
}
