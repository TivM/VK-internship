package com.example.demo.controller;

import com.example.demo.client.dto.*;
import com.example.demo.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/api/users/{id}")
    public GetUserResponse getUserById(@PathVariable Integer id){
        return usersService.getById(id);
    }

    @GetMapping("/api/users")
    public GetUserResponse[] getAllUsers(){
        return usersService.getAll();
    }

    @PostMapping("/api/users")
    public AddUserResponse addUser(@RequestBody AddUserRequest addUserRequest){
        return usersService.add(
                addUserRequest.name(), addUserRequest.email(), addUserRequest.address(),addUserRequest.phone(), addUserRequest.website(), addUserRequest.company()
        );
    }
}
