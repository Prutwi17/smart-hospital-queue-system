package com.hospital.repository;

import com.hospital.entity.QueueToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueTokenRepository extends JpaRepository<QueueToken, Long> {
}