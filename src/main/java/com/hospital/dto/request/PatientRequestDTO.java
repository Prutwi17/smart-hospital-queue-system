package com.hospital.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRequestDTO {

    private Integer age;

    private String gender;

    private String phone;

    private String bloodGroup;

    private String address;
}