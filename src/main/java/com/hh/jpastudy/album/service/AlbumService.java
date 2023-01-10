package com.hh.jpastudy.album.service;

import com.hh.jpastudy.album.entity.Album;
import com.hh.jpastudy.album.form.AlbumForm.Request.Find;
import com.hh.jpastudy.album.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.hh.jpastudy.album.mapper.AlbumMapper.mapper;


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
    @Transactional(readOnly = true)
    public Album get(Long id) {
        return albumRepository.findById(id).get();
    }
    @Transactional(readOnly = true)
    public Page<Album> getAll(Find find, Pageable pageable) {
        return albumRepository.findAll(find, pageable);
    }
    public Album modify(Album album) {
        return albumRepository.save(album);
    }
    public void remove(Long id) {
        albumRepository.deleteById(id);
    }
}