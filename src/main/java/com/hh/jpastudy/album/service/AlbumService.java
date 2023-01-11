package com.hh.jpastudy.album.service;

import com.hh.jpastudy.album.entity.Album;
import com.hh.jpastudy.album.form.AlbumForm;
import com.hh.jpastudy.album.form.AlbumForm.Request.Find;
import com.hh.jpastudy.album.form.AlbumForm.Response.FindOne;
import com.hh.jpastudy.album.mapper.AlbumMapper;
import com.hh.jpastudy.album.repository.AlbumRepository;
import com.hh.jpastudy.common.error.ResourceNotFoundException;
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
        return albumRepository.findByAlbumWithTrack(id)
                .orElseThrow(() -> new ResourceNotFoundException("앨범이 존재하지 않습니다."));
    }
    @Transactional(readOnly = true)
    public Page<Album> getAll(Find find, Pageable pageable) {
        return albumRepository.findAll(find, pageable);
    }
    public Long modify(Album album) {
        get(album.getId());
        albumRepository.save(album);
        return album.getId();
    }
    public void remove(Long id) {
        get(id);
        albumRepository.deleteById(id);
    }
}