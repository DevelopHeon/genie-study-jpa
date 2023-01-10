package com.hh.jpastudy.album.repository;

import com.hh.jpastudy.album.entity.Album;
import com.hh.jpastudy.album.form.AlbumForm.Request.Find;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


/**
 * @since       2023.01.10
 * @author      tony
 * @description album custom repository
 **********************************************************************************************************************/
public interface AlbumCustomRepository {
    Page<Album> findAll(Find find, Pageable pageable);
}