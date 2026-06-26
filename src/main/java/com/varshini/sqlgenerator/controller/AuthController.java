package com.varshini.sqlgenerator.controller;

import com.varshini.sqlgenerator.dto.AuthResponse;
import com.varshini.sqlgenerator.dto.LoginRequest;
import com.varshini.sqlgenerator.dto.RegisterRequest;
import com.varshini.sqlgenerator.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(
            @RequestBody RegisterRequest request) {

        String message = authService.register(request);

        return new AuthResponse(message, null);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request) {

        return authService.Login(request);
    }
}