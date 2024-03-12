package com.example.demo.service.impl;

import com.example.demo.client.api.JsonPlaceholderUsersClient;
import com.example.demo.client.dto.users.*;
import com.example.demo.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final JsonPlaceholderUsersClient usersClient;

    @Override
    @Cacheable(value = "users", unless = "#result == null")
    public GetUserResponse getById(Integer id) {
        return usersClient.getUserById(id);
    }

    @Override
    @Cacheable(value = "users", unless = "#result == null")
    public GetUserResponse[] getAll() {
        return usersClient.getAllUsers();
    }

    @Override
    public AddUserResponse add(String name, String email, UserAddressResponse address, String phone, String website, UserCompanyResponse company) {
        return usersClient.addUser(name, email, address, phone, website, company);
    }

    @Override
    public UpdateUserResponse update(Integer id, String name, String email, UserAddressResponse address, String phone, String website, UserCompanyResponse company) {
        return usersClient.updateUser(id, name, email, address, phone, website, company);
    }

    @Override
    public Void delete(Integer id) {
        return usersClient.deleteUser(id);
    }
}
