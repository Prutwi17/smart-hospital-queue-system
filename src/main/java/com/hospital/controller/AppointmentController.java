package com.hospital.controller;

import com.hospital.dto.request.AppointmentRequestDTO;
import com.hospital.dto.response.AppointmentResponseDTO;
import com.hospital.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponseDTO bookAppointment(
            @RequestBody AppointmentRequestDTO request) {

        return appointmentService.bookAppointment(request);
    }

    @GetMapping("/{id}")
    public AppointmentResponseDTO getAppointmentById(
            @PathVariable Long id) {

        return appointmentService.getAppointmentById(id);
    }

    @GetMapping
    public List<AppointmentResponseDTO> getAllAppointments() {

        return appointmentService.getAllAppointments();
    }

    @PutMapping("/{id}/cancel")
    public String cancelAppointment(
            @PathVariable Long id) {

        appointmentService.cancelAppointment(id);

        return "Appointment cancelled successfully";
    }
}