package com.example.car_service.repositories;

import com.example.car_service.model.Car;
import com.example.car_service.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByCar(Car car);

    List<Task> findAllByCar(Car car);
}
