package com.hh.jpastudy.album.repository;

import com.hh.jpastudy.album.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @since       2023.01.09
 * @author      tony
 * @description album repository
 **********************************************************************************************************************/
public interface AlbumRepository extends JpaRepository<Album, Long> {
}