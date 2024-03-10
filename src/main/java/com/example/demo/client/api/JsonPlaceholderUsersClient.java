package com.example.demo.client.api;

import com.example.demo.client.dto.*;

public interface JsonPlaceholderUsersClient {
    GetUserResponse[] getAllUsers();

    GetUserResponse getUserById(Integer id);

    AddUserResponse addUser(String name, String email, UserAddressResponse address, String phone, String website, UserCompanyResponse company);

    //UpdatePostResponse updatePost(Integer id, String title, String body);

    //Void deletePost(Integer id);
}
