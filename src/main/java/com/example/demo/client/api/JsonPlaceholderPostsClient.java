package com.example.demo.client.api;

import com.example.demo.client.dto.posts.AddPostResponse;
import com.example.demo.client.dto.posts.GetPostResponse;
import com.example.demo.client.dto.posts.UpdatePostResponse;

public interface JsonPlaceholderPostsClient {
    GetPostResponse[] getAllPosts();

    GetPostResponse getPostById(Integer id);

    AddPostResponse addPost(String title, String body, Integer userId);

    UpdatePostResponse updatePost(Integer id, String title, String body);

    Void deletePost(Integer id);
}
