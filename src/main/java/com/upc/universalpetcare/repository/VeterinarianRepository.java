package com.upc.universalpetcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upc.universalpetcare.model.Veterinarian;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
}
