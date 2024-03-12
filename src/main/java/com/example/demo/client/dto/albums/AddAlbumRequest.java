package com.example.demo.client.dto.albums;

public record AddAlbumRequest(
        Integer userId,
        String title
) {}
