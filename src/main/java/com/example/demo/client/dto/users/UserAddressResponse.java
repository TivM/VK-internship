package com.example.demo.client.dto.users;

public record UserAddressResponse(
        String street,
        String suite,
        String city,
        String zipcode,
        GeoAddressResponse geo
) {}