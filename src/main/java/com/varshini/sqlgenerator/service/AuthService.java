package com.varshini.sqlgenerator.service;

import com.varshini.sqlgenerator.dto.LoginRequest;
import com.varshini.sqlgenerator.dto.RegisterRequest;
import com.varshini.sqlgenerator.model.User;
import com.varshini.sqlgenerator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.varshini.sqlgenerator.security.JwtUtil;
import com.varshini.sqlgenerator.dto.AuthResponse;
import java.time.LocalDateTime;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request) {

        User existingUser =
                userRepository.findByEmail(request.getEmail());

        if(request.getUsername().isBlank() ||
                request.getEmail().isBlank() ||
                request.getPassword().isBlank()) {

            return "All fields are required";
        }
        if(existingUser != null) {
            return "Email Already Registered";
        }

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public AuthResponse Login(LoginRequest request) {


        User user =
                userRepository.findByEmail(request.getEmail());

        if(user == null) {
            return new AuthResponse(
                    "User Not Found",
                    null);
        }

        if(!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            return new AuthResponse(
                    "Invalid Password",
                    null);
        }

        String token =
                jwtUtil.generateToken(
                        user.getEmail());

        return new AuthResponse(
                "Login Successful",
                token);
    }
}