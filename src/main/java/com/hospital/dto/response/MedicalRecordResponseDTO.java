package com.hospital.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalRecordResponseDTO {

    private Long id;

    private String diagnosis;

    private String prescription;

    private String remarks;

    private String doctorName;

    private LocalDateTime createdAt;
}