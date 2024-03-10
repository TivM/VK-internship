package com.example.demo.auth;

public record AuthenticationRequest(
        String email,
        String password
) {}
