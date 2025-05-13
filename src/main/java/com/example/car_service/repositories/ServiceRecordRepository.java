package com.example.car_service.repositories;

import com.example.car_service.model.ServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ServiceRecordRepository extends JpaRepository<ServiceRecord, Long> {
    List<ServiceRecord> findAllByRecordDay(LocalDate date);

    List<ServiceRecord> findAllByRecordDayBetween(LocalDate startDate, LocalDate endDate);


}
