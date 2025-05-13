package com.example.car_service.repositories;

import com.example.car_service.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    boolean existsByPhoneNumber(String phoneNumber);

    Optional<Owner> findOwnerByPhoneNumber(String phoneNumber);
}
