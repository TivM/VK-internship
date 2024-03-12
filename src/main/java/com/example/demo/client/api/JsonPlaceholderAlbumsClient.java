package com.example.demo.client.api;

import com.example.demo.client.dto.albums.AddAlbumResponse;
import com.example.demo.client.dto.albums.GetAlbumResponse;
import com.example.demo.client.dto.albums.UpdateAlbumResponse;

public interface JsonPlaceholderAlbumsClient {
    GetAlbumResponse[] getAllAlbums();

    GetAlbumResponse getAlbumById(Integer id);

    AddAlbumResponse addAlbum(Integer userId, String title);

    UpdateAlbumResponse updateAlbum(Integer id, String title);

    Void deleteAlbum(Integer id);

}
