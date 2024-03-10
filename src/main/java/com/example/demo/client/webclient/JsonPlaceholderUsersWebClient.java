package com.example.demo.client.webclient;

import com.example.demo.client.api.JsonPlaceholderUsersClient;
import com.example.demo.client.dto.*;
import org.springframework.http.MediaType;
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

    @Override
    public GetUserResponse[] getAllUsers() {
        return webClient
                .get()
                .uri(baseUrl)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GetUserResponse[].class)
                .block();
    }

    @Override
    public AddUserResponse addUser(String name, String email, UserAddressResponse address, String phone, String website, UserCompanyResponse company) {
        return webClient
                .post()
                .uri(baseUrl)
                .bodyValue(new AddUserRequest(name, email, address, phone, website, company))
                .retrieve()
                .bodyToMono(AddUserResponse.class)
                .block();
    }
}
