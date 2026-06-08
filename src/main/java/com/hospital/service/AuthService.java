package com.hospital.service;

import com.hospital.dto.request.LoginRequestDTO;
import com.hospital.dto.request.RegisterRequestDTO;
import com.hospital.dto.response.AuthResponseDTO;

public interface AuthService {

    AuthResponseDTO register(RegisterRequestDTO request);

    AuthResponseDTO login(LoginRequestDTO request);
}