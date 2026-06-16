package com.hospital.service.impl;

import com.hospital.dto.request.EmergencyRequestDTO;
import com.hospital.dto.response.EmergencyResponseDTO;
import com.hospital.entity.EmergencyRequest;
import com.hospital.entity.Patient;
import com.hospital.entity.enums.PriorityLevel;
import com.hospital.exception.ResourceNotFoundException;
import com.hospital.repository.EmergencyRequestRepository;
import com.hospital.repository.PatientRepository;
import com.hospital.service.EmergencyRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmergencyRequestServiceImpl
        implements EmergencyRequestService {

    private final EmergencyRequestRepository emergencyRequestRepository;
    private final PatientRepository patientRepository;

    @Override
    public EmergencyResponseDTO createEmergencyRequest(
            EmergencyRequestDTO request) {

        Patient patient = patientRepository.findById(
                        request.getPatientId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Patient not found"));

        PriorityLevel priorityLevel =
                determinePriorityLevel(
                        request.getPriorityScore());

        EmergencyRequest emergencyRequest =
                EmergencyRequest.builder()
                        .symptoms(request.getSymptoms())
                        .priorityScore(
                                request.getPriorityScore())
                        .priorityLevel(priorityLevel)
                        .patient(patient)
                        .build();

        return mapToResponse(
                emergencyRequestRepository.save(
                        emergencyRequest));
    }

    @Override
    public EmergencyResponseDTO getEmergencyRequestById(
            Long id) {

        EmergencyRequest emergencyRequest =
                emergencyRequestRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Emergency request not found"));

        return mapToResponse(emergencyRequest);
    }

    @Override
    public List<EmergencyResponseDTO>
    getAllEmergencyRequests() {

        return emergencyRequestRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private PriorityLevel determinePriorityLevel(
            Integer score) {

        if (score >= 9) {
            return PriorityLevel.CRITICAL;
        }

        if (score >= 7) {
            return PriorityLevel.HIGH;
        }

        if (score >= 4) {
            return PriorityLevel.MEDIUM;
        }

        return PriorityLevel.LOW;
    }

    private EmergencyResponseDTO mapToResponse(
            EmergencyRequest emergencyRequest) {

        return EmergencyResponseDTO.builder()
                .id(emergencyRequest.getId())
                .patientName(
                        emergencyRequest.getPatient()
                                .getUser()
                                .getFullName())
                .symptoms(
                        emergencyRequest.getSymptoms())
                .priorityScore(
                        emergencyRequest.getPriorityScore())
                .priorityLevel(
                        emergencyRequest.getPriorityLevel()
                                .name())
                .createdAt(
                        emergencyRequest.getCreatedAt())
                .build();
    }
}