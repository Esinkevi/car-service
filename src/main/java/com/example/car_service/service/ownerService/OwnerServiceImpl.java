package com.example.car_service.service.ownerService;

import com.example.car_service.dto.OwnerDTO;
import com.example.car_service.model.Owner;
import com.example.car_service.model.repositories.OwnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class OwnerServiceImpl implements OwnerService{


    private final OwnerRepository ownerRepository;

    @Override
    public void createOwner(OwnerDTO ownerDTO) {
        Owner owner = new Owner();
        owner.setCars(new ArrayList<>());
        owner.setName(ownerDTO.getName());
        owner.setPhoneNumber(ownerDTO.getPhoneNumber());
        owner.setLastName(ownerDTO.getLastName());
        ownerRepository.save(owner);
    }

    @Override
    public Owner findOwnerByPhoneNumber(String phoneNumber) {
        return ownerRepository.findOwnerByPhoneNumber(phoneNumber).orElse(null);
    }

    @Override
    public List<Owner> findAllOwner() {
        return ownerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
        return ownerRepository.existsByPhoneNumber(phoneNumber);
    }
}
