package com.hh.jpastudy.album.service;

import com.hh.jpastudy.album.entity.Album;
import com.hh.jpastudy.album.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @since       2023.01.09
 * @author      sony
 * @description album service
 **********************************************************************************************************************/
@Service
@Transactional
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;

    public Album add(Album album) {
        return albumRepository.save(album);
    }
}