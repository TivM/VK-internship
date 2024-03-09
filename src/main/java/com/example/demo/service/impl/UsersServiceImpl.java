package com.example.demo.service.impl;

import com.example.demo.client.api.JsonPlaceholderUsersClient;
import com.example.demo.client.dto.GetUserResponse;
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
}
