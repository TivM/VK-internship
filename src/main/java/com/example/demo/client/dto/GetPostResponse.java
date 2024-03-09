package com.example.demo.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetPostResponse(
        Integer id,
        String title,
        String body,
        Integer userId
) {}
