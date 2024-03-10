package com.example.demo.service.impl;

import com.example.demo.client.api.JsonPlaceholderUsersClient;
import com.example.demo.client.dto.AddUserResponse;
import com.example.demo.client.dto.GetUserResponse;
import com.example.demo.client.dto.UserAddressResponse;
import com.example.demo.client.dto.UserCompanyResponse;
import com.example.demo.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final JsonPlaceholderUsersClient usersClient;

    @Override
    public GetUserResponse getById(Integer id) {
        return usersClient.getUserById(id);
    }

    @Override
    public GetUserResponse[] getAll() {
        return usersClient.getAllUsers();
    }

    @Override
    public AddUserResponse add(String name, String email, UserAddressResponse address, String phone, String website, UserCompanyResponse company) {
        return usersClient.addUser(name, email, address, phone, website, company);
    }
}
