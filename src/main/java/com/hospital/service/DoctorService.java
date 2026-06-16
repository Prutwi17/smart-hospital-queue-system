package com.hospital.service;

import com.hospital.dto.request.DoctorRequestDTO;
import com.hospital.dto.response.DoctorResponseDTO;

import java.util.List;

public interface DoctorService {

    DoctorResponseDTO createDoctor(
            DoctorRequestDTO request);

    DoctorResponseDTO getDoctorById(
            Long id);

    List<DoctorResponseDTO> getAllDoctors();

    DoctorResponseDTO updateDoctor(
            Long id,
            DoctorRequestDTO request);

    void deleteDoctor(
            Long id);
}