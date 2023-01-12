package com.hh.jpastudy.album;

import com.hh.jpastudy.album.entity.Album;
import com.hh.jpastudy.album.form.AlbumForm.Request.Add;
import com.hh.jpastudy.artitst.entity.Artist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @since       2023.01.12
 * @author      sony
 * @description album test support
 **********************************************************************************************************************/
public class AlbumTestSupport {

    public static Add addAlbum(Long artistId, List<Add.SoundTrack> soundTracks) {
        return Add.builder()
                .artist(Add.Artist.builder()
                        .id(artistId)
                        .build())
                .title("앨범 제목")
                .releaseDate(LocalDate.now())
                .genre("발라드")
                .description("앨범 설명")
                .soundTracks(soundTracks)
                .build();
    }

    public static List<Add.SoundTrack> addSoundTracks() {
        List<Add.SoundTrack> soundTracks = new ArrayList<>();

        for (int i = 1; i < 5; i++) {

            Add.SoundTrack track = Add.SoundTrack.builder()
                    .orderNo(i)
                    .title("음원" + i)
                    .playTime("03:2" + i)
                    .exposure(true)
                    .build();

            soundTracks.add(track);
        }
        return soundTracks;
    }

    public static Album album(Long artistId) {
        return Album.builder()
                .artist(Artist.builder()
                        .id(artistId)
                        .build())
                .title("샘플 앨범")
                .releaseDate(LocalDate.now())
                .description("앨범 설명 샬라샬라")
                .genre("댄스")
                .build();
    }
}