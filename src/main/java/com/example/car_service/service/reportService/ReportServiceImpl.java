package com.example.car_service.service.reportService;

import com.example.car_service.dto.CarDTO;
import com.example.car_service.dto.OwnerDTO;
import com.example.car_service.dto.reportsDTO.ResultsForPeriodDTO;
import com.example.car_service.mapper.CarMapper;
import com.example.car_service.mapper.OwnerMapper;
import com.example.car_service.mapper.ResultsForPeriodMapper;
import com.example.car_service.model.ServiceRecord;
import com.example.car_service.repositories.ServiceRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportServiceImpl implements ReportService {

    private final ServiceRecordRepository serviceRecordRepository;


    @Override
    public List<CarDTO> getCarsForDate(LocalDate startDate, LocalDate endDate) {

        List<ServiceRecord> serviceRecordList = serviceRecordRepository.findAllByRecordDayBetween(startDate, endDate);

        if (serviceRecordList.isEmpty()) {
            log.warn("Нет авто в период с {} по {}", startDate, endDate);
        } else {
            log.info("Найдено {} авто в период с {} по {}", serviceRecordList.size(), startDate, endDate);
        }

        return serviceRecordList.stream()
                .map(ServiceRecord::getCar)
                .map(CarMapper::toDTO)
                .toList();
    }

    @Override
    public List<OwnerDTO> getClientsForDate(LocalDate startDate, LocalDate endDate) {

        List<ServiceRecord> serviceRecordList = serviceRecordRepository.findAllByRecordDayBetween(startDate, endDate);

        if (serviceRecordList.isEmpty()) {
            log.warn("Нет клиентов в период с {} по {}", startDate, endDate);
        } else {
            log.info("Найдено {} клиентов в период с {} по {}", serviceRecordList.size(), startDate, endDate);
        }

        return serviceRecordList.stream()
                .map(ServiceRecord::getOwner)
                .map(OwnerMapper::toDTO)
                .toList();
    }

    @Override
    public List<ResultsForPeriodDTO> getResultForPeriod(LocalDate startDate, LocalDate endDate) {

        List<ServiceRecord> serviceRecordList = serviceRecordRepository.findAllByRecordDayBetween(startDate, endDate);
        if (serviceRecordList.isEmpty()) {
            log.warn("Нет результатов в период с {} по {}", startDate, endDate);
        } else {
            log.info("Найдено {} результатов в период с {} по {}", serviceRecordList.size(), startDate, endDate);
        }

        return serviceRecordList.stream()
                .map(ResultsForPeriodMapper::toDTO)
                .toList();
    }
}
