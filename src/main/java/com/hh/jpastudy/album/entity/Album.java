package com.hh.jpastudy.album.entity;

import com.hh.jpastudy.artitst.entity.Artist;
import com.hh.jpastudy.common.entity.Base;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sony
 * @description album
 * @since 2023.01.09
 **********************************************************************************************************************/
@Entity(name = "album")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Album extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate releaseDate;
    @Column(length = 100)
    private String genre;
    @Column(length = 1000)
    private String description;

    @ElementCollection
    @CollectionTable(name = "sound_track"
            , joinColumns = @JoinColumn(name = "album_id")
    )
    private List<SoundTrack> soundTracks = new ArrayList<>();

}