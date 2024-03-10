package com.example.demo.configuration;


import com.example.demo.client.api.JsonPlaceholderAlbumsClient;
import com.example.demo.client.api.JsonPlaceholderPostsClient;
import com.example.demo.client.api.JsonPlaceholderUsersClient;
import com.example.demo.client.webclient.JsonPlaceholderAlbumsWebClient;
import com.example.demo.client.webclient.JsonPlaceholderPostsWebClient;
import com.example.demo.client.webclient.JsonPlaceholderUsersWebClient;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

@Configuration
public class ClientConfig {
    @Value("${webclient.timeout}")
    int timeout;

    @Bean
    public WebClient webClient() {
        final HttpClient httpClient = HttpClient
                .create()
                .compress(true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, timeout)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(timeout, TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(timeout, TimeUnit.MILLISECONDS));
                });

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    @Bean
    public JsonPlaceholderPostsClient jsonPlaceholderPostsWebClient(
            WebClient webClient,
            @Value("${posts.url.base}") String baseUrl
    ) {
        return new JsonPlaceholderPostsWebClient(webClient, baseUrl);
    }

    @Bean
    public JsonPlaceholderUsersClient jsonPlaceholderUsersWebClient(
            WebClient webClient,
            @Value("${users.url.base}") String baseUrl
    ) {
        return new JsonPlaceholderUsersWebClient(webClient, baseUrl);
    }

    @Bean
    public JsonPlaceholderAlbumsClient jsonPlaceholderAlbumsWebClient(
            WebClient webClient,
            @Value("${albums.url.base}") String baseUrl
    ) {
        return new JsonPlaceholderAlbumsWebClient(webClient, baseUrl);
    }

}
