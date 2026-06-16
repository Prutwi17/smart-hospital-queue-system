package com.hospital.service.impl;

import com.hospital.dto.request.DoctorRequestDTO;
import com.hospital.dto.response.DoctorResponseDTO;
import com.hospital.entity.Department;
import com.hospital.entity.Doctor;
import com.hospital.entity.User;
import com.hospital.exception.ResourceNotFoundException;
import com.hospital.repository.DepartmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.UserRepository;
import com.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public DoctorResponseDTO createDoctor(
            DoctorRequestDTO request) {

        User user = userRepository.findById(
                        request.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"));

        Department department =
                departmentRepository.findById(
                                request.getDepartmentId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Department not found"));

        Doctor doctor = Doctor.builder()
                .specialization(
                        request.getSpecialization())
                .experience(
                        request.getExperience())
                .consultationFee(
                        request.getConsultationFee())
                .available(
                        request.getAvailable())
                .user(user)
                .department(department)
                .build();

        return mapToResponse(
                doctorRepository.save(doctor));
    }

    @Override
    public DoctorResponseDTO getDoctorById(
            Long id) {

        Doctor doctor =
                doctorRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Doctor not found"));

        return mapToResponse(doctor);
    }

    @Override
    public List<DoctorResponseDTO> getAllDoctors() {

        return doctorRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public DoctorResponseDTO updateDoctor(
            Long id,
            DoctorRequestDTO request) {

        Doctor doctor =
                doctorRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Doctor not found"));

        doctor.setSpecialization(
                request.getSpecialization());

        doctor.setExperience(
                request.getExperience());

        doctor.setConsultationFee(
                request.getConsultationFee());

        doctor.setAvailable(
                request.getAvailable());

        return mapToResponse(
                doctorRepository.save(doctor));
    }

    @Override
    public void deleteDoctor(Long id) {

        Doctor doctor =
                doctorRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Doctor not found"));

        doctorRepository.delete(doctor);
    }

    private DoctorResponseDTO mapToResponse(
            Doctor doctor) {

        return DoctorResponseDTO.builder()
                .id(doctor.getId())
                .fullName(
                        doctor.getUser().getFullName())
                .email(
                        doctor.getUser().getEmail())
                .specialization(
                        doctor.getSpecialization())
                .experience(
                        doctor.getExperience())
                .consultationFee(
                        doctor.getConsultationFee())
                .available(
                        doctor.getAvailable())
                .departmentName(
                        doctor.getDepartment().getName())
                .build();
    }
}