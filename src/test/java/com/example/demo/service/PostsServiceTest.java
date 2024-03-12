package com.example.demo.service;

import com.example.demo.client.api.JsonPlaceholderPostsClient;
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
public class PostsServiceTest {

    @Autowired
    private PostsService service;

    @SpyBean
    @Autowired
    private JsonPlaceholderPostsClient client;

    @Test
    void getById__getPostByIdFromCache_returnGetPostResponseFromCache() {
        final int postId = 1;

        GetPostResponse post = service.getById(postId);
        assertNotNull(post, "Post is not found");

        GetPostResponse cachedPost = service.getById(postId);
        assertNotNull(cachedPost, "Post is not found");

        verify(client, times(1)).getPostById(postId);
    }

    @Test
    void getAll__getAllPostsFromCache_returnArrayGetPostResponse() {
        GetPostResponse[] posts = service.getAll();
        assertNotNull(posts, "Posts is not found");

        GetPostResponse[] cachedPosts = service.getAll();
        assertNotNull(cachedPosts, "Posts is not found");

        verify(client, times(1)).getAllPosts();
    }
}
