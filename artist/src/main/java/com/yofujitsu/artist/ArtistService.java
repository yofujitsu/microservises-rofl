package com.yofujitsu.artist;

import com.yofujitsu.artist.client.AlbumClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final AlbumClient albumClient;

    public void saveArtist(Artist artist) {
        artistRepository.save(artist);
    }
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Artist getArtistById(Long id) {
        return artistRepository.findById(id).orElse(Artist.builder().name("NOT_FOUND").age(null).country("NOT_FOUND").primaryGenre("NOT_FOUND").build());
    }

    public FullArtistResponse findArtistWithAlbums(Long artistId) {
        var artist = getArtistById(artistId);
        var albums = albumClient.getAllAlbumsByArtist(artistId);
        return FullArtistResponse.builder()
                .name(artist.getName()).age(artist.getAge()).country(artist.getCountry()).primaryGenre(artist.getPrimaryGenre()).albums(albums)
                .build();
    }
}
