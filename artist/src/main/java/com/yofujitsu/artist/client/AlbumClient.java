package com.yofujitsu.artist.client;

import com.yofujitsu.artist.Album;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "album-service", url = "${application.config.albums-url}")
public interface AlbumClient {

    @GetMapping("/artist/{artistId}")
    List<Album> getAllAlbumsByArtist(@PathVariable("artistId") Long artistId);
}
