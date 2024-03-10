package com.example.demo.service;

import com.example.demo.client.api.JsonPlaceholderPostsClient;
import com.example.demo.client.dto.GetPostResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PostsServiceTest {

    @Autowired
    private PostsService service;

    @SpyBean
    @Autowired
    private JsonPlaceholderPostsClient client;

    @Test
    void testFindBookById() {
        final int postId = 1;

        GetPostResponse post = service.getById(postId);
        assertNotNull(post, "Post is not found");

        GetPostResponse cachedPost = service.getById(postId);
        assertNotNull(cachedPost, "Post is not found");

        verify(client, times(1)).getPostById(postId);
    }
}
