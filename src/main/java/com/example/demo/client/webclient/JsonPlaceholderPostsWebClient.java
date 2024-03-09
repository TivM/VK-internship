package com.example.demo.client.webclient;

import com.example.demo.client.api.JsonPlaceholderPostsClient;
import com.example.demo.client.dto.*;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class JsonPlaceholderPostsWebClient implements JsonPlaceholderPostsClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    private final WebClient webClient;
    private final String baseUrl;

    public JsonPlaceholderPostsWebClient(WebClient webClient) {
        this.webClient = webClient;
        this.baseUrl = BASE_URL;
    }

    public JsonPlaceholderPostsWebClient(WebClient webClient, String baseUrl) {
        this.webClient = webClient;
        this.baseUrl = baseUrl;
    }

    @Override
    public GetPostResponse[] getAllPosts() {
        return webClient
                .get()
                .uri(baseUrl)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GetPostResponse[].class)
                .block();
    }

    @Override
    public GetPostResponse getPostById(Integer id) {
        return webClient
                .get()
                .uri(baseUrl + "/" + id.toString())
                .retrieve()
                .bodyToMono(GetPostResponse.class)
                .block();
    }

    @Override
    public AddPostResponse addPost(String title, String body, Integer userId) {
        return webClient
                .post()
                .uri(baseUrl)
                .bodyValue(new AddPostRequest(title, body, userId))
                .retrieve()
                .bodyToMono(AddPostResponse.class)
                .block();
    }

    @Override
    public UpdatePostResponse updatePost(Integer id, String title, String body) {
        return webClient
                .put()
                .uri(baseUrl + "/" + id.toString())
                .bodyValue(new UpdatePostRequest(title, body))
                .retrieve()
                .bodyToMono(UpdatePostResponse.class)
                .block();
    }

    @Override
    public Void deletePost(Integer id) {
        return webClient
                .delete()
                .uri(baseUrl + "/" + id.toString())
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
