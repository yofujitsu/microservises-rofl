package com.yofujitsu.artist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FullArtistResponse {
    private String name;
    private Long age;
    private String country;
    private String primaryGenre;
    private List<Album> albums;
}
