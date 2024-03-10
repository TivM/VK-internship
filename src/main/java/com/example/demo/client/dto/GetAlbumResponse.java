package com.example.demo.client.dto;

public record GetAlbumResponse(
        Integer userId,
        Integer id,
        String title
) {}
