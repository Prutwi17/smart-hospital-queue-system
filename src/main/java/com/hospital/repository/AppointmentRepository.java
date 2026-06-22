package com.hospital.repository;

import com.hospital.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hospital.entity.enums.AppointmentStatus;

import java.time.LocalDate;

@Repository
public interface AppointmentRepository
        extends JpaRepository<Appointment, Long> {
    long countByStatus(AppointmentStatus status);

    long countByAppointmentDate(LocalDate appointmentDate);

}