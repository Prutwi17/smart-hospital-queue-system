package com.hospital.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorRequestDTO {

    private Long userId;

    private Long departmentId;

    private String specialization;

    private Integer experience;

    private BigDecimal consultationFee;

    private Boolean available;
}