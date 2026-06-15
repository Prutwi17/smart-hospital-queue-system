package com.hospital.controller;

import com.hospital.dto.request.LoginRequestDTO;
import com.hospital.dto.request.RegisterRequestDTO;
import com.hospital.dto.response.AuthResponseDTO;
import com.hospital.security.JwtService;
import com.hospital.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(
            @RequestBody RegisterRequestDTO request) {

        return ResponseEntity.ok(
                authService.register(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(
            @RequestBody LoginRequestDTO request) {

        return ResponseEntity.ok(
                authService.login(request)
        );
    }
    @GetMapping("/token-test")
    public String tokenTest() {

        return jwtService.generateToken(
                "test@gmail.com"
        );
    }
    @GetMapping("/test")
    public String test() {
        return "JWT Working";
    }
}