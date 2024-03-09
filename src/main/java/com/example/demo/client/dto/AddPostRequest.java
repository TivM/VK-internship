package com.example.demo.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddPostRequest(
        String title,
        String body,
        Integer userId
) {}
