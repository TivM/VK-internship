package com.example.demo.service;

import com.example.demo.client.dto.*;

public interface PostsService {
    GetPostResponse[] getAll();

    GetPostResponse getById(Integer id);

    AddPostResponse add(String title, String body, Integer userId);

    UpdatePostResponse update(Integer id, String title, String body);

    Void delete(Integer id);
}
