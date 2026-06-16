package com.hospital.service;

import com.hospital.dto.request.PatientRequestDTO;
import com.hospital.dto.response.PatientResponseDTO;

import java.util.List;

public interface PatientService {

    PatientResponseDTO createPatient(
            PatientRequestDTO request);

    PatientResponseDTO getPatientById(
            Long id);

    List<PatientResponseDTO> getAllPatients();

    PatientResponseDTO updatePatient(
            Long id,
            PatientRequestDTO request);

    void deletePatient(
            Long id);
}