package com.example.demo.client.api;

import com.example.demo.client.dto.AddPostResponse;
import com.example.demo.client.dto.GetPostResponse;
import com.example.demo.client.dto.UpdatePostResponse;

public interface JsonPlaceholderPostsClient {
    GetPostResponse[] getAllPosts();

    GetPostResponse getPostById(Integer id);

    AddPostResponse addPost(String title, String body, Integer userId);

    UpdatePostResponse updatePost(Integer id, String title, String body);

    Void deletePost(Integer id);
}
