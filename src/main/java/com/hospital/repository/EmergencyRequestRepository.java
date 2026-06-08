package com.hospital.repository;

import com.hospital.entity.EmergencyRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRequestRepository extends JpaRepository<EmergencyRequest, Long> {
}