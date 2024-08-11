package com.upc.universalpetcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upc.universalpetcare.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
