package com.hospital.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentResponseDTO {

    private Long appointmentId;

    private String patientName;

    private String doctorName;

    private String status;

    private String priorityLevel;
}