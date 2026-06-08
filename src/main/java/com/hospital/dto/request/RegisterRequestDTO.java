package com.hospital.dto.request;

import com.hospital.entity.enums.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestDTO {

    private String fullName;

    private String email;

    private String password;

    private Role role;
}