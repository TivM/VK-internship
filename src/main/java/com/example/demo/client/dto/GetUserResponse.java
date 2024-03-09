package com.example.demo.client.dto;

import java.util.List;

public record GetUserResponse(
        Integer id,
        String name,
        String email,
        UserAddressResponse address,
        String phone,
        String website,
        UserCompanyResponse userCompany
) {}
