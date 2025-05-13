package com.example.car_service.service.reportService;

import com.example.car_service.dto.CarDTO;
import com.example.car_service.dto.OwnerDTO;
import com.example.car_service.dto.reportsDTO.ResultsForPeriodDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {

    List<CarDTO> getCarsForDate(LocalDate startDate, LocalDate endDate);

    List<OwnerDTO> getClientsForDate(LocalDate startDate, LocalDate endDate);

    List<ResultsForPeriodDTO> getResultForPeriod(LocalDate startDate, LocalDate endDate);
}
