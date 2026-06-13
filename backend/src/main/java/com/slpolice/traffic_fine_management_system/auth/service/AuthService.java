package com.slpolice.traffic_fine_management_system.auth.service;

import com.slpolice.traffic_fine_management_system.auth.dto.AuthResponse;
import com.slpolice.traffic_fine_management_system.auth.dto.LoginRequest;
import com.slpolice.traffic_fine_management_system.auth.dto.RegisterRequest;
import com.slpolice.traffic_fine_management_system.security.JwtUtil;
import com.slpolice.traffic_fine_management_system.users.entity.User;
import com.slpolice.traffic_fine_management_system.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already in use";
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepository.save(user);
        return "User registered successfully";
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token, user.getRole().name(), user.getName());
    }
}