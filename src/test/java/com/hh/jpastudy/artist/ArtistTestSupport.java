package com.hh.jpastudy.artist;

import com.hh.jpastudy.artitst.entity.Artist;
import com.hh.jpastudy.artitst.enumerate.Agency;
import com.hh.jpastudy.artitst.form.ArtistForm.Request.Add;

import java.time.LocalDate;

/**
 * @since       2023.01.12
 * @author      sony
 * @description artist test support
 **********************************************************************************************************************/
public class ArtistTestSupport {

    public static Add add() {
        return Add.builder()
                .name("가수1")
                .birth(LocalDate.now())
                .nationality("한국")
                .agency(Agency.SM)
                .description("가수에 대한 설명")
                .build();
    }

    public static Artist artist() {
        return Artist.builder()
                .name("샘플1")
                .birth(LocalDate.now())
                .nationality("한국")
                .agency(Agency.SM)
                .description("설명 불라불라")
                .build();
    }
    
}