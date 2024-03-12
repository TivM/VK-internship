package com.example.demo.client.dto.users;

public record UpdateUserRequest(
        String name,
        String email,
        UserAddressResponse address,
        String phone,
        String website,
        UserCompanyResponse company
) {}
