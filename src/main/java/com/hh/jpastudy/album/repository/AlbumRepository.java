package com.hh.jpastudy.album.repository;

import com.hh.jpastudy.album.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sony
 * @description album repository
 * @since 2023.01.09
 **********************************************************************************************************************/
public interface AlbumRepository extends JpaRepository<Album, Long>, AlbumCustomRepository {
    Boolean existsByArtistId(Long id);

}