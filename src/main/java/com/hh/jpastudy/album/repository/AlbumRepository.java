package com.hh.jpastudy.album.repository;

import com.hh.jpastudy.album.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author sony
 * @description album repository
 * @since 2023.01.09
 **********************************************************************************************************************/
public interface AlbumRepository extends JpaRepository<Album, Long>, AlbumCustomRepository {

    @Query("select count(a.artist) from album a where a.artist.id = :id")
    Long findByArtistExist(@Param("id") Long id);

}