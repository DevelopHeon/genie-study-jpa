package com.hh.jpastudy.artitst.repository;

import com.hh.jpastudy.artitst.entity.Artist;
import com.hh.jpastudy.artitst.form.ArtistForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @since       2023.01.09
 * @author      sony
 * @description artist custom repository
 **********************************************************************************************************************/
public interface ArtistCustomRepository {
    Page<Artist> findAll(ArtistForm.Request.Find find, Pageable pageable);
}