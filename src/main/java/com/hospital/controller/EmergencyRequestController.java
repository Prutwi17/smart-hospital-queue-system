package com.hospital.controller;

import com.hospital.dto.request.EmergencyRequestDTO;
import com.hospital.dto.response.EmergencyResponseDTO;
import com.hospital.service.EmergencyRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emergencies")
@RequiredArgsConstructor
public class EmergencyRequestController {

    private final EmergencyRequestService emergencyRequestService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmergencyResponseDTO createEmergencyRequest(
            @RequestBody EmergencyRequestDTO request) {

        return emergencyRequestService
                .createEmergencyRequest(request);
    }

    @GetMapping("/{id}")
    public EmergencyResponseDTO getEmergencyRequestById(
            @PathVariable Long id) {

        return emergencyRequestService
                .getEmergencyRequestById(id);
    }

    @GetMapping
    public List<EmergencyResponseDTO>
    getAllEmergencyRequests() {

        return emergencyRequestService
                .getAllEmergencyRequests();
    }
}