package com.yofujitsu.artist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Album {

    private String title;
    private Long tracksCount;
    private LocalDate releaseDate;
    private String genre;
    private String coverUrl;
    private Long artistId;
}
