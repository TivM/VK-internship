package com.example.demo.client.webclient;

import com.example.demo.client.api.JsonPlaceholderUsersClient;
import com.example.demo.client.dto.GetPostResponse;
import com.example.demo.client.dto.GetUserResponse;
import org.springframework.web.reactive.function.client.WebClient;

public class JsonPlaceholderUsersWebClient implements JsonPlaceholderUsersClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    private final WebClient webClient;
    private final String baseUrl;

    public JsonPlaceholderUsersWebClient(WebClient webClient) {
        this.webClient = webClient;
        this.baseUrl = BASE_URL;
    }

    public JsonPlaceholderUsersWebClient(WebClient webClient, String baseUrl) {
        this.webClient = webClient;
        this.baseUrl = baseUrl;
    }

    @Override
    public GetUserResponse getUserById(Integer id) {
        return webClient
                .get()
                .uri(baseUrl + "/" + id.toString())
                .retrieve()
                .bodyToMono(GetUserResponse.class)
                .block();
    }
}
