package com.yofujitsu.album;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;

    public void saveAlbum(Album album) {
        albumRepository.save(album);
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public List<Album> getAllAlbumsByArtist(Long artistId) {
        return albumRepository.findAllByArtistId(artistId);
    }
}
