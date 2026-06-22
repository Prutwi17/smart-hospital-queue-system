package com.hospital.repository;

import com.hospital.entity.EmergencyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.entity.enums.PriorityLevel;

public interface EmergencyRequestRepository
        extends JpaRepository<EmergencyRequest, Long> {
    long countByPriorityLevel(PriorityLevel priorityLevel);
}