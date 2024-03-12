package com.example.demo.service.impl;

import com.example.demo.client.api.JsonPlaceholderAlbumsClient;
import com.example.demo.client.dto.albums.AddAlbumResponse;
import com.example.demo.client.dto.albums.GetAlbumResponse;
import com.example.demo.client.dto.albums.UpdateAlbumResponse;
import com.example.demo.service.AlbumsService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumsServiceImpl implements AlbumsService {

    private final JsonPlaceholderAlbumsClient albumsClient;

    @Override
    @Cacheable(value = "albums", unless = "#result == null")
    public GetAlbumResponse getById(Integer id) {
        return albumsClient.getAlbumById(id);
    }

    @Override
    @Cacheable(value = "albums", unless = "#result == null")
    public GetAlbumResponse[] getAll() {
        return albumsClient.getAllAlbums();
    }

    @Override
    public AddAlbumResponse add(Integer userId, String title) {
        return albumsClient.addAlbum(userId, title);
    }

    @Override
    public UpdateAlbumResponse update(Integer id, String title) {
        return albumsClient.updateAlbum(id, title);
    }

    @Override
    @CacheEvict(value = "albums", key = "#id")
    public Void delete(Integer id) {
        return albumsClient.deleteAlbum(id);
    }
}
