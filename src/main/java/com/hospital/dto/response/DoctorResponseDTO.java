package com.hospital.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorResponseDTO {

    private Long id;

    private String fullName;

    private String email;

    private String specialization;

    private Integer experience;

    private BigDecimal consultationFee;

    private Boolean available;

    private String departmentName;
}