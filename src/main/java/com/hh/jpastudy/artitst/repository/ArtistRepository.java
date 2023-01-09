package com.hh.jpastudy.artitst.repository;

import com.hh.jpastudy.artitst.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @since       2023.01.09
 * @author      sony
 * @description artist repository
 **********************************************************************************************************************/
public interface ArtistRepository extends JpaRepository<Artist, Long>, ArtistCustomRepository{
}