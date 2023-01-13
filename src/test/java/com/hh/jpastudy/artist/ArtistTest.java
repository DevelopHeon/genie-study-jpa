package com.hh.jpastudy.artist;

import com.hh.jpastudy.album.AlbumTestSupport;
import com.hh.jpastudy.album.entity.Album;
import com.hh.jpastudy.album.service.AlbumService;
import com.hh.jpastudy.artitst.entity.Artist;
import com.hh.jpastudy.artitst.enumerate.Agency;
import com.hh.jpastudy.artitst.form.ArtistForm.Request.Add;
import com.hh.jpastudy.artitst.form.ArtistForm.Request.Modify;
import com.hh.jpastudy.artitst.service.ArtistService;
import com.hh.jpastudy.common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.time.LocalDate;

import static com.hh.jpastudy.album.AlbumTestSupport.album;
import static com.hh.jpastudy.artist.ArtistTestSupport.add;
import static com.hh.jpastudy.artist.ArtistTestSupport.artist;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author sony
 * @description artist test
 * @since 2023.01.09
 **********************************************************************************************************************/
public class ArtistTest extends BaseTest {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private AlbumService albumService;

    private Long id;

    @BeforeEach
    public void setUp() {
        id = artistService.add(artist());
    }

    @Test
    @DisplayName("아티스트 생성")
    void add_artist() throws Exception {

        mockMvc.perform(post("/api/artists")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(toJson(add())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("가수1"));
    }

    @Test
    @DisplayName("잘못된 요청으로 생성")
    void bad_request_add() throws Exception {
        Artist add = Artist.builder().build();

        mockMvc.perform(post("/api/artists")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(toJson(add)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("아티스트 단일 조회")
    void get_artist() throws Exception {

        mockMvc.perform(get("/api/artists/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id));
    }

    @Test
    @DisplayName("없는 아티스트 조회")
    void get_not_found() throws Exception {

        mockMvc.perform(get("/api/artists/{id}", 9991L))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("아티스트 전체 조회")
    void get_page() throws Exception {

        for (int i = 0; i < 30; i++) {
            artistService.add(artist());
        }

        mockMvc.perform(get("/api/artists")
                        .queryParam("page", "0")
                        .queryParam("size", "10")
                        .queryParam("name", "가수1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("아티스트 수정")
    void modify_artist() throws Exception {

        Modify modify = Modify.builder()
                .name("가수명 수정")
                .birth(LocalDate.now())
                .nationality("호주")
                .agency(Agency.ANTENA)
                .description("설명 솰랴솰랴")
                .build();

        mockMvc.perform(put("/api/artists/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(toJson(modify)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("아티스트 삭제")
    void remove_artist() throws Exception {

        mockMvc.perform(delete("/api/artists/{id}", id))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("등록한 앨범이 있는 아티스트 삭제")
    void remove_bad_request_artist() throws Exception {

        albumService.add(album(id));

        mockMvc.perform(delete("/api/artists/{id}", id))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}