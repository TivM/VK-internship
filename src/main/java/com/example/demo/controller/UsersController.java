package com.example.demo.controller;

import com.example.demo.client.dto.GetPostResponse;
import com.example.demo.client.dto.GetUserResponse;
import com.example.demo.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/api/users/{id}")
    public GetUserResponse getUserById(@PathVariable Integer id){
        return usersService.getById(id);
    }
}
