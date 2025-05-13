package com.example.car_service.mapper;

import com.example.car_service.dto.OwnerDTO;
import com.example.car_service.model.Owner;

public class OwnerMapper {

    public static OwnerDTO toDTO(Owner owner) {
        if (owner == null) return null;

        OwnerDTO dto = new OwnerDTO();
        dto.setName(owner.getName());
        dto.setLastName(owner.getLastName());
        dto.setPhoneNumber(owner.getPhoneNumber());
        return dto;
    }

    public static Owner toEntity(OwnerDTO dto) {
        if (dto == null) return null;

        Owner owner = new Owner();
        owner.setName(dto.getName());
        owner.setLastName(dto.getLastName());
        owner.setPhoneNumber(dto.getPhoneNumber());
        return owner;
    }
}
