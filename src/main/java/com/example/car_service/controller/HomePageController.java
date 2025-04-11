package com.example.car_service.controller;

import com.example.car_service.dto.serviceDTO.ServiceRecordForHomePageDTO;
import com.example.car_service.service.recordService.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomePageController {

    private final RecordService recordService;


    @GetMapping()
    public String homePage(Model model) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        List<ServiceRecordForHomePageDTO> todayRecords = recordService.getRecordsForTodayAndTomorrow(today);
        List<ServiceRecordForHomePageDTO> tomorrowRecords = recordService.getRecordsForTodayAndTomorrow(tomorrow);

        model.addAttribute("todayRecords", todayRecords);
        model.addAttribute("tomorrowRecords", tomorrowRecords);

        return "index";
    }
}
