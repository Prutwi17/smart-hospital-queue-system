package com.hospital.service.impl;

import com.hospital.dto.response.DashboardResponseDTO;
import com.hospital.entity.enums.AppointmentStatus;
import com.hospital.entity.enums.PriorityLevel;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DepartmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.EmergencyRequestRepository;
import com.hospital.repository.PatientRepository;
import com.hospital.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;
    private final AppointmentRepository appointmentRepository;
    private final EmergencyRequestRepository emergencyRequestRepository;

    @Override
    public DashboardResponseDTO getAdminDashboard() {

        return DashboardResponseDTO.builder()
                .totalPatients(patientRepository.count())
                .totalDoctors(doctorRepository.count())
                .totalDepartments(departmentRepository.count())
                .totalAppointments(appointmentRepository.count())
                .todayAppointments(
                        appointmentRepository.countByAppointmentDate(LocalDate.now())
                )
                .pendingAppointments(
                        appointmentRepository.countByStatus(AppointmentStatus.PENDING)
                )
                .completedAppointments(
                        appointmentRepository.countByStatus(AppointmentStatus.COMPLETED)
                )
                .cancelledAppointments(
                        appointmentRepository.countByStatus(AppointmentStatus.CANCELLED)
                )
                .totalEmergencyRequests(
                        emergencyRequestRepository.count()
                )
                .criticalEmergencyRequests(
                        emergencyRequestRepository.countByPriorityLevel(PriorityLevel.CRITICAL)
                )
                .build();
    }
}