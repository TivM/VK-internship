package com.example.demo.client.dto.posts;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddPostRequest(
        String title,
        String body,
        Integer userId
) {}
