package com.example.demo.service;

import com.example.demo.client.api.JsonPlaceholderUsersClient;
import com.example.demo.client.dto.users.GetUserResponse;
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
public class UsersServiceTest {

    @Autowired
    private UsersService service;

    @SpyBean
    @Autowired
    private JsonPlaceholderUsersClient client;

    @Test
    void getById__getUserByIdFromCache_returnGetUserResponseFromCache() {
        final int userId = 1;

        GetUserResponse user = service.getById(userId);
        assertNotNull(user, "User is not found");

        GetUserResponse cachedUser = service.getById(userId);
        assertNotNull(cachedUser, "User is not found");

        verify(client, times(1)).getUserById(userId);
    }

    @Test
    void getAll__getAllUsersFromCache_returnArrayGetUserResponse() {
        GetUserResponse[] users = service.getAll();
        assertNotNull(users, "Users is not found");

        GetUserResponse[] cachedUsers = service.getAll();
        assertNotNull(cachedUsers, "Users is not found");

        verify(client, times(1)).getAllUsers();
    }

    @Test
    void delete_deleteUserAndCacheEvict_callGetByIdTwoTimes() {
        final int userId = 1;

        service.getById(userId);

        service.delete(userId);

        service.getById(userId);

        verify(client, times(2)).getUserById(userId);
    }
}
