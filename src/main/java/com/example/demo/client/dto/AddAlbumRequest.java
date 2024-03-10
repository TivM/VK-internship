package com.example.demo.client.dto;

public record AddAlbumRequest(
        Integer userId,
        String title
) {}
