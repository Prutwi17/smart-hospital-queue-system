package com.hospital.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentResponseDTO {

    private Long appointmentId;

    private String appointmentNumber;

    private String patientName;

    private String doctorName;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    private String status;

    private String priorityLevel;

    private Integer estimatedWaitTime;

    private String doctorRemarks;

    private LocalDateTime createdAt;
}