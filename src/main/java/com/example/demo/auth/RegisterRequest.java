package com.example.demo.auth;

import com.example.demo.user.Role;

public record RegisterRequest(
        String firstname,
        String lastname,
        String email,
        String password
        //Role role

) {}
