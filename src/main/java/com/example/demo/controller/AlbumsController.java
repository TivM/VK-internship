package com.example.demo.controller;

import com.example.demo.client.dto.*;
import com.example.demo.service.AlbumsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AlbumsController {

    private final AlbumsService albumsService;

    @GetMapping("/api/albums/{id}")
    public GetAlbumResponse getAlbumById(@PathVariable Integer id){
        return albumsService.getById(id);
    }

    @GetMapping("/api/albums")
    public GetAlbumResponse[] getAll(){
        return albumsService.getAll();
    }

    @PostMapping("/api/albums")
    public AddAlbumResponse addAlbum(@RequestBody AddAlbumRequest addAlbumRequest){
        return albumsService.add(addAlbumRequest.userId(), addAlbumRequest.title());
    }

    @PutMapping ("/api/albums/{id}")
    public UpdateAlbumResponse updateAlbumById(
            @PathVariable Integer id,
            @RequestBody UpdateAlbumRequest updateAlbumRequest){
        return albumsService.update(id, updateAlbumRequest.title());
    }

    @DeleteMapping ("/api/albums/{id}")
    public Void deleteAlbumById(@PathVariable Integer id){
        return albumsService.delete(id);
    }

}
