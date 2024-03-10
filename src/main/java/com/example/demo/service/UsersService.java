package com.example.demo.service;

import com.example.demo.client.dto.*;

public interface UsersService {
    GetUserResponse getById(Integer id);

    GetUserResponse[] getAll();

    AddUserResponse add(String name, String email, UserAddressResponse address, String phone, String website, UserCompanyResponse company);
}
