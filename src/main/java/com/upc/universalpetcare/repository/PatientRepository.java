package com.upc.universalpetcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upc.universalpetcare.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
