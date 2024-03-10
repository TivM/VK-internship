package com.example.demo.controller;

import com.example.demo.client.dto.*;
import com.example.demo.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;

    @GetMapping("/api/posts")
    public GetPostResponse[] getAll(){
        return postsService.getAll();
    }

    @GetMapping("/api/posts/{id}")
    public GetPostResponse getPostById(@PathVariable Integer id){
        return postsService.getById(id);
    }

    @PostMapping ("/api/posts")
    public AddPostResponse addPost(@RequestBody AddPostRequest addPostRequest){
        return postsService.add(addPostRequest.title(), addPostRequest.body(), addPostRequest.userId());
    }

    @PutMapping ("/api/posts/{id}")
    public UpdatePostResponse updatePostById(
            @PathVariable Integer id,
            @RequestBody UpdatePostRequest updatePostRequest){
        return postsService.update(id, updatePostRequest.title(), updatePostRequest.body());
    }

    @DeleteMapping ("/api/posts/{id}")
    public Void deletePostById(@PathVariable Integer id){
        return postsService.delete(id);
    }

}
