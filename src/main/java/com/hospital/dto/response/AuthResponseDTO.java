package com.hospital.dto.response;

import com.hospital.entity.enums.Role;
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

    private Role role;

    private String token;
}