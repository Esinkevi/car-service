package com.example.car_service.controller;

import com.example.car_service.dto.CarDTO;
import com.example.car_service.dto.OwnerDTO;
import com.example.car_service.dto.ServiceRecordDTO;
import com.example.car_service.dto.TaskDTO;
import com.example.car_service.service.recordService.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/records/new")
@RequiredArgsConstructor
public class ServiceRecordController {

    private final RecordService recordService;

    @GetMapping
    public String showForm(@RequestParam(required = false) String phoneNumber,
                           @RequestParam(required = false) String numberPlate,
                           Model model) {

        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            boolean ownerExists = recordService.ownerExists(phoneNumber);
            model.addAttribute("ownerExists", ownerExists);
            model.addAttribute("phoneNumber", phoneNumber);

            if (ownerExists && numberPlate != null && !numberPlate.isEmpty()) {
                boolean carExists = recordService.carExist(numberPlate);
                model.addAttribute("carExists", carExists);
                model.addAttribute("numberPlate", numberPlate);
            }
        }

        return "ServiceRecord/add-records-form";
    }

    @PostMapping("/createNewOwner")
    public String createNewOwner(@RequestParam String phoneNumber,
                                 @RequestParam String name,
                                 @RequestParam String lastName) {
        OwnerDTO ownerDTO = new OwnerDTO(name, lastName, phoneNumber);
        recordService.createOwner(ownerDTO);

        try {
            String encodedPhoneNumber = URLEncoder.encode(phoneNumber, "UTF-8");
            return "redirect:/records/new?phoneNumber=" + encodedPhoneNumber;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "redirect:/records/new";
        }
    }

    @PostMapping("/createCar")
    public String createCar(@RequestParam String phoneNumber,
                            @RequestParam String numberPlate,
                            @RequestParam String carBrand,
                            @RequestParam String carModel,
                            @RequestParam String vinCode,
                            @RequestParam String fuelType) {

        CarDTO carDTO = new CarDTO(numberPlate, carBrand, carModel, vinCode, fuelType);
        recordService.createCar(phoneNumber, carDTO);

        try {
            String encodedPhoneNumber = URLEncoder.encode(phoneNumber, "UTF-8");
            String encodedNumberPlate = URLEncoder.encode(numberPlate, "UTF-8");
            return "redirect:/records/new?phoneNumber=" + encodedPhoneNumber + "&numberPlate=" + encodedNumberPlate;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "redirect:/records/new";
        }
    }

    @PostMapping("/createTask")
    public String createTask(@RequestParam String phoneNumber,
                             @RequestParam String numberPlate,
                             @RequestParam String taskDescription,
                             @RequestParam Integer odometer,
                             @RequestParam double price) {
        TaskDTO taskDTO = new TaskDTO(taskDescription, odometer, price, numberPlate);
        recordService.createTask(taskDTO);
        try {
            String encodedPhoneNumber = URLEncoder.encode(phoneNumber, "UTF-8");
            String encodedNumberPlate = URLEncoder.encode(numberPlate, "UTF-8");
            return "redirect:/records/new?phoneNumber=" + encodedPhoneNumber + "&numberPlate=" + encodedNumberPlate;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "redirect:/records/new";
        }
    }


    @PostMapping("/createRecordOnService")
    public String createRecord(@RequestParam String phoneNumber,
                               @RequestParam String numberPlate,
                               @RequestParam String recordDay,
                               @RequestParam String recordTime,
                               RedirectAttributes redirectAttributes) {
        ServiceRecordDTO serviceRecordDTO = new ServiceRecordDTO(recordDay, recordTime);
        recordService.createRecordOnService(serviceRecordDTO, phoneNumber, numberPlate);

        redirectAttributes.addFlashAttribute("recordCreated", true);

        try {
            String encodedPhone = URLEncoder.encode(phoneNumber, "UTF-8");
            String encodedPlate = URLEncoder.encode(numberPlate, "UTF-8");
            return "redirect:/records/new?phoneNumber=" + encodedPhone + "&numberPlate=" + encodedPlate;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "redirect:/records/new";
        }
    }

}
