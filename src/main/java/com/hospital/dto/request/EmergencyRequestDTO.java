package com.hospital.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmergencyRequestDTO {

    private Long patientId;

    private String symptoms;
}