package com.hospital.service;

import com.hospital.dto.request.EmergencyRequestDTO;
import com.hospital.dto.response.EmergencyResponseDTO;

import java.util.List;

public interface EmergencyRequestService {

    EmergencyResponseDTO createEmergencyRequest(
            EmergencyRequestDTO request);

    EmergencyResponseDTO getEmergencyRequestById(
            Long id);

    List<EmergencyResponseDTO> getAllEmergencyRequests();
}