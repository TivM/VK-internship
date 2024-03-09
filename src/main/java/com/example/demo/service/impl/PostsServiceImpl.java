package com.example.demo.service.impl;

import com.example.demo.client.api.JsonPlaceholderPostsClient;
import com.example.demo.client.dto.AddPostResponse;
import com.example.demo.client.dto.GetPostResponse;
import com.example.demo.client.dto.UpdatePostResponse;
import com.example.demo.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {

    private final JsonPlaceholderPostsClient postsClient;
    @Override
    public GetPostResponse[] getAll() {
        return postsClient.getAllPosts();
    }

    @Override
    public GetPostResponse getById(Integer id) {
        return postsClient.getPostById(id);
    }

    @Override
    public AddPostResponse add(String title, String body, Integer userId) {
        return postsClient.addPost(title, body, userId);
    }

    @Override
    public UpdatePostResponse update(Integer id, String title, String body) {
        return postsClient.updatePost(id, title, body);
    }

    @Override
    public Void delete(Integer id) {
        return postsClient.deletePost(id);
    }
}
