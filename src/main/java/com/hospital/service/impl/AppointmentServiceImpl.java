package com.hospital.service.impl;

import com.hospital.dto.request.AppointmentRequestDTO;
import com.hospital.dto.response.AppointmentResponseDTO;
import com.hospital.entity.Appointment;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import com.hospital.entity.enums.AppointmentStatus;
import com.hospital.entity.enums.PriorityLevel;
import com.hospital.exception.ResourceNotFoundException;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;
import com.hospital.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public AppointmentResponseDTO bookAppointment(
            AppointmentRequestDTO request) {

        Patient patient = patientRepository.findById(
                        request.getPatientId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Patient not found"));

        Doctor doctor = doctorRepository.findById(
                        request.getDoctorId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Doctor not found"));

        Appointment appointment = Appointment.builder()
                .appointmentNumber(
                        generateAppointmentNumber())
                .appointmentDate(
                        request.getAppointmentDate())
                .appointmentTime(
                        request.getAppointmentTime())
                .reason(
                        request.getReason())
                .status(
                        AppointmentStatus.PENDING)
                .priorityLevel(
                        PriorityLevel.LOW)
                .patient(patient)
                .doctor(doctor)
                .estimatedWaitTime(15)
                .build();

        Appointment savedAppointment =
                appointmentRepository.save(appointment);

        return mapToResponse(savedAppointment);
    }

    @Override
    public AppointmentResponseDTO getAppointmentById(
            Long appointmentId) {

        Appointment appointment =
                appointmentRepository.findById(
                                appointmentId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Appointment not found"));

        return mapToResponse(appointment);
    }

    @Override
    public List<AppointmentResponseDTO> getAllAppointments() {

        return appointmentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void cancelAppointment(
            Long appointmentId) {

        Appointment appointment =
                appointmentRepository.findById(
                                appointmentId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Appointment not found"));

        appointment.setStatus(
                AppointmentStatus.CANCELLED);

        appointmentRepository.save(appointment);
    }

    private AppointmentResponseDTO mapToResponse(
            Appointment appointment) {

        return AppointmentResponseDTO.builder()
                .appointmentId(
                        appointment.getId())
                .appointmentNumber(
                        appointment.getAppointmentNumber())
                .patientName(
                        appointment.getPatient()
                                .getUser()
                                .getFullName())
                .doctorName(
                        appointment.getDoctor()
                                .getUser()
                                .getFullName())
                .appointmentDate(
                        appointment.getAppointmentDate())
                .appointmentTime(
                        appointment.getAppointmentTime())
                .status(
                        appointment.getStatus().name())
                .priorityLevel(
                        appointment.getPriorityLevel().name())
                .estimatedWaitTime(
                        appointment.getEstimatedWaitTime())
                .doctorRemarks(
                        appointment.getDoctorRemarks())
                .createdAt(
                        appointment.getCreatedAt())
                .build();
    }

    private String generateAppointmentNumber() {

        return "APT-" +
                UUID.randomUUID()
                        .toString()
                        .substring(0, 8)
                        .toUpperCase();
    }
}