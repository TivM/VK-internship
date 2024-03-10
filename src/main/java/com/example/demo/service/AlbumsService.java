package com.example.demo.service;

import com.example.demo.client.dto.*;

public interface AlbumsService {
    GetAlbumResponse getById(Integer id);

    GetAlbumResponse[] getAll();

    AddAlbumResponse add(Integer userId, String title);

    UpdateAlbumResponse update(Integer id, String title);

    Void delete(Integer id);
}
