package com.example.car_service.controller.clients;

import com.example.car_service.model.Owner;
import com.example.car_service.service.ownerService.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientsController {

    private final OwnerService ownerService;

    @GetMapping
    public String getAllClients(Model model) {
        List<Owner> clients = ownerService.findAllOwner();
        model.addAttribute("clients", clients);
        return "clients/clients-list";
    }

    //Создай GET-метод для "/clients/edit/{id}" в ClientsController — для показа формы редактирования.

    @PostMapping("/delete/{id}")
    public String deleteOwner(@PathVariable Long id){
        ownerService.delete(id);
        return "redirect:/clients";
    }
}
