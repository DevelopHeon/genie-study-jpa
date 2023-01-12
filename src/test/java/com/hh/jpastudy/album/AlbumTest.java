package com.hh.jpastudy.album;

import com.hh.jpastudy.album.entity.Album;
import com.hh.jpastudy.album.form.AlbumForm.Request.Add;
import com.hh.jpastudy.album.form.AlbumForm.Request.Modify;
import com.hh.jpastudy.album.service.AlbumService;
import com.hh.jpastudy.artist.ArtistTestSupport;
import com.hh.jpastudy.artitst.entity.Artist;
import com.hh.jpastudy.artitst.service.ArtistService;
import com.hh.jpastudy.common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.hh.jpastudy.album.AlbumTestSupport.*;
import static com.hh.jpastudy.artist.ArtistTestSupport.artist;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author sony
 * @description album test
 * @since 2023.01.10
 **********************************************************************************************************************/
public class AlbumTest extends BaseTest {

    @Autowired
    AlbumService albumService;
    @Autowired
    ArtistService artistService;

    private Long artistId;
    private Long id;

    @BeforeEach
    public void setUp() {
        artistId = artistService.add(artist()).getId();
        id = albumService.add(album(artistId)).getId();
    }

    @Test
    @DisplayName("앨범 생성 테스트")
    void add_album() throws Exception {

        Add add = addAlbum(artistId, addSoundTracks());

        mockMvc.perform(post("/api/albums")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(toJson(add)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("잘못된 요청으로 앨범 생성")
    void bad_request_add() throws Exception {
        Album add = Album.builder().build();

        mockMvc.perform(post("/api/albums")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(toJson(add)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("앨범 단일 조회")
    void get_album() throws Exception {
        mockMvc.perform(get("/api/albums/{id}", id))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("없는 앨범 조회")
    void get_not_found() throws Exception {
        mockMvc.perform(get("/api/albums/{id}", 14523L))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("앨범 전체 조회")
    void get_page() throws Exception {

        for (int i = 0; i < 30; i++) {
            albumService.add(album(artistId));
        }

        mockMvc.perform(get("/api/albums")
                        .queryParam("size", "5")
                        .queryParam("page", "0"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("앨범 수정")
    void modify_album() throws Exception {

        List<Modify.SoundTrack> soundTracks = new ArrayList<>();

        for (int i = 1; i < 5; i++) {

            Modify.SoundTrack track = Modify.SoundTrack
                    .builder()
                    .orderNo(i)
                    .title("음원 수정" + i)
                    .playTime("03:30")
                    .exposure(true)
                    .build();

            soundTracks.add(track);

        }

        Modify modify = Modify.builder()
                .artist(Modify.Artist
                        .builder()
                        .id(artistId)
                        .build())
                .title("앨범 수정")
                .releaseDate(LocalDate.now())
                .genre("발라드")
                .description("설명 수정")
                .soundTracks(soundTracks)
                .build();

        mockMvc.perform(put("/api/albums/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(toJson(modify)))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("앨범 삭제")
    void remove_album() throws Exception {

        mockMvc.perform(delete("/api/albums/{id}", id))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("음원 순서 중복 테스트")
    void duplicated_sound_track() throws Exception {
        List<Modify.SoundTrack> soundTracks = new ArrayList<>();

        for (int i = 1; i < 5; i++) {

            Modify.SoundTrack track = Modify.SoundTrack
                    .builder()
                    .orderNo(1)
                    .title("음원 수정" + i)
                    .playTime("03:30")
                    .exposure(true)
                    .build();

            soundTracks.add(track);

        }
        Modify modify = Modify.builder()
                .artist(Modify.Artist
                        .builder()
                        .id(artistId)
                        .build())
                .title("앨범 수정")
                .releaseDate(LocalDate.now())
                .genre("발라드")
                .description("설명 수정")
                .soundTracks(soundTracks)
                .build();

        mockMvc.perform(put("/api/albums/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(toJson(modify)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}