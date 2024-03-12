package com.example.demo.service;

import com.example.demo.client.api.JsonPlaceholderAlbumsClient;
import com.example.demo.client.api.JsonPlaceholderPostsClient;
import com.example.demo.client.dto.albums.GetAlbumResponse;
import com.example.demo.client.dto.posts.GetPostResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AlbumsServiceTest {

    @Autowired
    private AlbumsService service;

    @SpyBean
    @Autowired
    private JsonPlaceholderAlbumsClient client;

    @Test
    void getById__getAlbumByIdFromCache_returnGetAlbumResponse() {
        final int albumId = 1;

        GetAlbumResponse album = service.getById(albumId);
        assertNotNull(album, "Album is not found");

        GetAlbumResponse cachedAlbum = service.getById(albumId);
        assertNotNull(cachedAlbum, "Album is not found");

        verify(client, times(1)).getAlbumById(albumId);
    }

    @Test
    void getAll__getAllAlbumsFromCache_returnArrayGetAlbumResponse() {
        GetAlbumResponse[] albums = service.getAll();
        assertNotNull(albums, "Albums is not found");

        GetAlbumResponse[] cachedAlbums = service.getAll();
        assertNotNull(cachedAlbums, "Albums is not found");

        verify(client, times(1)).getAllAlbums();
    }
}
