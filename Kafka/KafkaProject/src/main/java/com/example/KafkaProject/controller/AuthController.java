package com.example.KafkaProject.controller;

import com.example.KafkaProject.dto.LoginRequest;
import com.example.KafkaProject.dto.LoginResponse;
import com.example.KafkaProject.util.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        // TEMP: Hardcoded user (for learning)
        if ("admin".equals(request.getUsername()) &&
                "admin123".equals(request.getPassword())) {

            String token = jwtUtil.generateToken(request.getUsername());
            return new LoginResponse(token);
        }

        throw new RuntimeException("Invalid credentials");
    }
}