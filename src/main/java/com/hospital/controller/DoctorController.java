package com.hospital.controller;

import com.hospital.dto.request.DoctorRequestDTO;
import com.hospital.dto.response.DoctorResponseDTO;
import com.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorResponseDTO createDoctor(
            @RequestBody DoctorRequestDTO request) {

        return doctorService.createDoctor(request);
    }

    @GetMapping("/{id}")
    public DoctorResponseDTO getDoctorById(
            @PathVariable Long id) {

        return doctorService.getDoctorById(id);
    }

    @GetMapping
    public List<DoctorResponseDTO> getAllDoctors() {

        return doctorService.getAllDoctors();
    }

    @PutMapping("/{id}")
    public DoctorResponseDTO updateDoctor(
            @PathVariable Long id,
            @RequestBody DoctorRequestDTO request) {

        return doctorService.updateDoctor(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(
            @PathVariable Long id) {

        doctorService.deleteDoctor(id);

        return "Doctor deleted successfully";
    }
}