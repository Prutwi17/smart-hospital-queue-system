package com.hospital.service.impl;

import com.hospital.dto.request.PatientRequestDTO;
import com.hospital.dto.response.PatientResponseDTO;
import com.hospital.entity.Patient;
import com.hospital.entity.User;
import com.hospital.exception.ResourceNotFoundException;
import com.hospital.repository.PatientRepository;
import com.hospital.repository.UserRepository;
import com.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    @Override
    public PatientResponseDTO createPatient(
            PatientRequestDTO request) {

        User user = userRepository.findById(
                        request.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"));

        Patient patient = Patient.builder()
                .age(request.getAge())
                .gender(request.getGender())
                .phone(request.getPhone())
                .bloodGroup(request.getBloodGroup())
                .address(request.getAddress())
                .user(user)
                .build();

        return mapToResponse(
                patientRepository.save(patient));
    }

    @Override
    public PatientResponseDTO getPatientById(
            Long id) {

        return mapToResponse(
                patientRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Patient not found")));
    }

    @Override
    public List<PatientResponseDTO> getAllPatients() {

        return patientRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public PatientResponseDTO updatePatient(
            Long id,
            PatientRequestDTO request) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Patient not found"));

        patient.setAge(request.getAge());
        patient.setGender(request.getGender());
        patient.setPhone(request.getPhone());
        patient.setBloodGroup(request.getBloodGroup());
        patient.setAddress(request.getAddress());

        return mapToResponse(
                patientRepository.save(patient));
    }

    @Override
    public void deletePatient(Long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Patient not found"));

        patientRepository.delete(patient);
    }

    private PatientResponseDTO mapToResponse(
            Patient patient) {

        return PatientResponseDTO.builder()
                .id(patient.getId())
                .fullName(patient.getUser().getFullName())
                .email(patient.getUser().getEmail())
                .age(patient.getAge())
                .gender(patient.getGender())
                .phone(patient.getPhone())
                .bloodGroup(patient.getBloodGroup())
                .address(patient.getAddress())
                .build();
    }
}
