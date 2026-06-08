package com.hospital.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmergencyResponseDTO {

    private Long requestId;

    private String symptoms;

    private Integer priorityScore;

    private String priorityLevel;

    private String status;
}