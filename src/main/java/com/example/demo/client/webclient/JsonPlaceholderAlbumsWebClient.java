package com.example.demo.client.webclient;

import com.example.demo.client.api.JsonPlaceholderAlbumsClient;
import com.example.demo.client.dto.*;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class JsonPlaceholderAlbumsWebClient implements JsonPlaceholderAlbumsClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/albums";

    private final WebClient webClient;
    private final String baseUrl;

    public JsonPlaceholderAlbumsWebClient(WebClient webClient) {
        this.webClient = webClient;
        this.baseUrl = BASE_URL;
    }

    public JsonPlaceholderAlbumsWebClient(WebClient webClient, String baseUrl) {
        this.webClient = webClient;
        this.baseUrl = baseUrl;
    }

    @Override
    public GetAlbumResponse getAlbumById(Integer id) {
        return webClient
                .get()
                .uri(baseUrl + "/" + id.toString())
                .retrieve()
                .bodyToMono(GetAlbumResponse.class)
                .block();
    }

    @Override
    public GetAlbumResponse[] getAllAlbums() {
        return webClient
                .get()
                .uri(baseUrl)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GetAlbumResponse[].class)
                .block();
    }

    @Override
    public AddAlbumResponse addAlbum(Integer userId, String title) {
        return webClient
                .post()
                .uri(baseUrl)
                .bodyValue(new AddAlbumRequest(userId, title))
                .retrieve()
                .bodyToMono(AddAlbumResponse.class)
                .block();
    }

    @Override
    public UpdateAlbumResponse updateAlbum(Integer id, String title) {
        return webClient
                .put()
                .uri(baseUrl + "/" + id.toString())
                .bodyValue(new UpdateAlbumRequest(title))
                .retrieve()
                .bodyToMono(UpdateAlbumResponse.class)
                .block();
    }

    @Override
    public Void deleteAlbum(Integer id) {
        return webClient
                .delete()
                .uri(baseUrl + "/" + id.toString())
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
