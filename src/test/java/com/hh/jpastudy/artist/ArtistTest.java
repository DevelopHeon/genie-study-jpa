package com.hh.jpastudy.artist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hh.jpastudy.artitst.controller.ArtistController;
import com.hh.jpastudy.artitst.enumerate.Agency;
import com.hh.jpastudy.artitst.form.ArtistForm;
import com.hh.jpastudy.artitst.form.ArtistForm.Request.Add;
import com.hh.jpastudy.artitst.form.ArtistForm.Response.FindOne;
import com.hh.jpastudy.artitst.service.ArtistService;
import com.hh.jpastudy.common.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @since       2023.01.09
 * @author      sony
 * @description artist test
 **********************************************************************************************************************/
public class ArtistTest extends BaseTest {

    @Autowired
    private ArtistController artistController;

    @Test
    @DisplayName("아티스트 생성")
    void create_artist() throws Exception {
        Add add = artistAdd();
        mockMvc.perform(post("/api/artists")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(add)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("아티스트 단건 조회")
    void get_artist() throws Exception {
        Long id = artistController.add(artistAdd()).getId();

        mockMvc.perform(get("/api/artists/{id}", id))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("아티스트 전체 조회")
    void getAll_artist() throws Exception {
        artistController.add(artistAdd());
        artistController.add(artistAdd());
        artistController.add(artistAdd());

        mockMvc.perform(get("/api/artists")
                        .queryParam("name", "가수"))
                .andExpect(status().isOk())
                .andDo(print());
    }


    private Add artistAdd() {
        return Add.builder()
                .name("가수1")
                .birth(LocalDate.now())
                .nationality("한국")
                .agency(Agency.SM)
                .description("가수에 대한 설명")
                .build();
    }
}