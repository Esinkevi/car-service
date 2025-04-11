package com.example.car_service.service.ownerService;

import com.example.car_service.dto.OwnerDTO;
import com.example.car_service.model.Owner;

import java.util.List;

public interface OwnerService {

    List<Owner> findAllOwner();

    void delete(Long id);

    boolean existsByPhoneNumber(String phoneNumber);

    void createOwner(OwnerDTO ownerDTO);

    Owner findOwnerByPhoneNumber(String phoneNumber);
}
