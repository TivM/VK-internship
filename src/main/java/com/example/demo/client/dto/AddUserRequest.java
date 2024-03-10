package com.example.demo.client.dto;

public record AddUserRequest(
        String name,
        String email,
        UserAddressResponse address,
        String phone,
        String website,
        UserCompanyResponse company
) {}
