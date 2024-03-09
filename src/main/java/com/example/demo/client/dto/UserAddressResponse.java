package com.example.demo.client.dto;

import java.util.List;

public record UserAddressResponse(
        String street,
        String suite,
        String city,
        String zipcode,
        GeoAddressResponse geo
) {}