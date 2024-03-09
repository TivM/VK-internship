package com.example.demo.client.api;

import com.example.demo.client.dto.AddPostResponse;
import com.example.demo.client.dto.GetPostResponse;
import com.example.demo.client.dto.GetUserResponse;
import com.example.demo.client.dto.UpdatePostResponse;

public interface JsonPlaceholderUsersClient {
    //GetPostResponse[] getAllPosts();

    GetUserResponse getUserById(Integer id);

    //AddPostResponse addPost(String title, String body, Integer userId);

    //UpdatePostResponse updatePost(Integer id, String title, String body);

    //Void deletePost(Integer id);
}
