package com.hospital.controller;

import com.hospital.dto.request.PatientRequestDTO;
import com.hospital.dto.response.PatientResponseDTO;
import com.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PatientResponseDTO createPatient(
            @RequestBody PatientRequestDTO request) {

        return patientService.createPatient(request);
    }

    @GetMapping("/{id}")
    public PatientResponseDTO getPatientById(
            @PathVariable Long id) {

        return patientService.getPatientById(id);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<PatientResponseDTO> getAllPatients() {

        return patientService.getAllPatients();
    }

    @PutMapping("/{id}")
    public PatientResponseDTO updatePatient(
            @PathVariable Long id,
            @RequestBody PatientRequestDTO request) {

        return patientService.updatePatient(id, request);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(
            @PathVariable Long id) {

        patientService.deletePatient(id);

        return "Patient deleted successfully";
    }
}