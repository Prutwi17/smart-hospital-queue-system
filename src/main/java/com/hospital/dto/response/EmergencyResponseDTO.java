package com.hospital.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmergencyResponseDTO {

    private Long id;

    private String patientName;

    private String symptoms;

    private Integer priorityScore;

    private String priorityLevel;

    private LocalDateTime createdAt;
}