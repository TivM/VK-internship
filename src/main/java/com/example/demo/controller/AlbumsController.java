package com.example.demo.controller;

import com.example.demo.client.dto.*;
import com.example.demo.service.AlbumsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'ALBUMS')")
public class AlbumsController {

    private final AlbumsService albumsService;

    @GetMapping("/api/albums/{id}")
    @PreAuthorize("hasAnyAuthority('admin:read', 'albums:read')")
    public GetAlbumResponse getAlbumById(@PathVariable Integer id){
        return albumsService.getById(id);
    }

    @GetMapping("/api/albums")
    @PreAuthorize("hasAnyAuthority('admin:read', 'albums:read')")
    public GetAlbumResponse[] getAll(){
        return albumsService.getAll();
    }

    @PostMapping("/api/albums")
    @PreAuthorize("hasAuthority('admin:create')")
    public AddAlbumResponse addAlbum(@RequestBody AddAlbumRequest addAlbumRequest){
        return albumsService.add(addAlbumRequest.userId(), addAlbumRequest.title());
    }

    @PutMapping ("/api/albums/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public UpdateAlbumResponse updateAlbumById(
            @PathVariable Integer id,
            @RequestBody UpdateAlbumRequest updateAlbumRequest){
        return albumsService.update(id, updateAlbumRequest.title());
    }

    @DeleteMapping ("/api/albums/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public Void deleteAlbumById(@PathVariable Integer id){
        return albumsService.delete(id);
    }

}
