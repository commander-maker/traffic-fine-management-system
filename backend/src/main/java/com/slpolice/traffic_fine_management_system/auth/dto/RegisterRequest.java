package com.slpolice.traffic_fine_management_system.auth.dto;

import com.slpolice.traffic_fine_management_system.users.entity.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}