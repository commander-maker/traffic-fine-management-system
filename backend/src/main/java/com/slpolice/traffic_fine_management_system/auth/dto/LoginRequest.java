package com.slpolice.traffic_fine_management_system.auth.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}