package com.example.demo.client.api;

import com.example.demo.client.dto.*;

public interface JsonPlaceholderAlbumsClient {
    GetAlbumResponse[] getAllAlbums();

    GetAlbumResponse getAlbumById(Integer id);

    AddAlbumResponse addAlbum(Integer userId, String title);

    UpdateAlbumResponse updateAlbum(Integer id, String title);

    Void deleteAlbum(Integer id);

}
