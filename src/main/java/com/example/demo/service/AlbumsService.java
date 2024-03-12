package com.example.demo.service;

import com.example.demo.client.dto.albums.AddAlbumResponse;
import com.example.demo.client.dto.albums.GetAlbumResponse;
import com.example.demo.client.dto.albums.UpdateAlbumResponse;

public interface AlbumsService {
    GetAlbumResponse getById(Integer id);

    GetAlbumResponse[] getAll();

    AddAlbumResponse add(Integer userId, String title);

    UpdateAlbumResponse update(Integer id, String title);

    Void delete(Integer id);
}
