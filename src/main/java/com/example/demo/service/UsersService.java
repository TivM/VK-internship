package com.example.demo.service;

import com.example.demo.client.dto.GetPostResponse;
import com.example.demo.client.dto.GetUserResponse;

public interface UsersService {
    GetUserResponse getById(Integer id);
}
