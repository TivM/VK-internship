package com.example.demo.service;

import com.example.demo.client.dto.users.*;

public interface UsersService {
    GetUserResponse getById(Integer id);

    GetUserResponse[] getAll();

    AddUserResponse add(String name, String email, UserAddressResponse address, String phone, String website, UserCompanyResponse company);

    UpdateUserResponse update(Integer id, String name, String email, UserAddressResponse address, String phone, String website, UserCompanyResponse company);

    Void delete(Integer id);
}
