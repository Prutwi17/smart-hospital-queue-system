package com.hospital.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponseDTO {

    private Long id;

    private String fullName;

    private String email;

    private Integer age;

    private String gender;

    private String bloodGroup;
}