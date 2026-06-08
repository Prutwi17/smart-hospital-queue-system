package com.hospital.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponseDTO {

    private Long userId;

    private String fullName;

    private String email;

    private String role;

    private String token;
}