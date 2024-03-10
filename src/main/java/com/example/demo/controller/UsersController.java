package com.example.demo.controller;

import com.example.demo.client.dto.*;
import com.example.demo.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PutMapping ("/api/users/{id}")
    public UpdateUserResponse updateUserById(
            @PathVariable Integer id,
            @RequestBody UpdateUserRequest updateUserRequest){
        return usersService.update(
                id, updateUserRequest.name(), updateUserRequest.email(), updateUserRequest.address(),
                updateUserRequest.phone(), updateUserRequest.website(), updateUserRequest.company());
    }

    @DeleteMapping ("/api/users/{id}")
    public Void deleteUserById(@PathVariable Integer id){
        return usersService.delete(id);
    }
}
