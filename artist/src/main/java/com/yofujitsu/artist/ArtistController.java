package com.yofujitsu.artist;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/artists")
public class ArtistController {

    private final ArtistService artistService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addArtist(@RequestBody Artist artist) {
        artistService.saveArtist(artist);
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists() {
        return ResponseEntity.ok(artistService.getAllArtists());
    }

    @GetMapping("/albums/{albumId}")
    public ResponseEntity<FullArtistResponse> getArtistByAlbumId(@PathVariable Long albumId) {
        return ResponseEntity.ok(artistService.findArtistWithAlbums(albumId));
    }
}
