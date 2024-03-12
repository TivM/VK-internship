package com.example.demo.client.api;

import com.example.demo.client.dto.users.*;

public interface JsonPlaceholderUsersClient {
    GetUserResponse[] getAllUsers();

    GetUserResponse getUserById(Integer id);

    AddUserResponse addUser(String name, String email, UserAddressResponse address, String phone, String website, UserCompanyResponse company);

    UpdateUserResponse updateUser(Integer id, String name, String email, UserAddressResponse address, String phone, String website, UserCompanyResponse company);

    Void deleteUser(Integer id);
}
