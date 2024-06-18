package com.yofujitsu.album;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/albums")
public class AlbumController {

    private final AlbumService albumService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Album album) {
        albumService.saveAlbum(album);
    }

    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums() {
        return ResponseEntity.ok(albumService.getAllAlbums());
    }

    @GetMapping("/artist/{artistId}")
    public ResponseEntity<List<Album>> getAllAlbumsByArtist(@PathVariable Long artistId) {
        return ResponseEntity.ok(albumService.getAllAlbumsByArtist(artistId));
    }
}
