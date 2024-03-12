package com.example.demo.client.dto.albums;

public record GetAlbumResponse(
        Integer userId,
        Integer id,
        String title
) {}
