package com.hh.jpastudy.artitst.service;

import com.hh.jpastudy.album.repository.AlbumRepository;
import com.hh.jpastudy.artitst.entity.Artist;
import com.hh.jpastudy.artitst.form.ArtistForm.Request.Find;
import com.hh.jpastudy.artitst.repository.ArtistRepository;
import com.hh.jpastudy.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author sony
 * @description artist service
 * @since 2023.01.09
 **********************************************************************************************************************/
@Service
@Transactional
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    @Transactional(readOnly = true)
    public Page<Artist> getAll(Find find, Pageable pageable) {
        return artistRepository.findAll(find, pageable);
    }

    @Transactional(readOnly = true)
    public Artist get(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("아티스트를 찾을 수 없습니다."));
    }

    public Artist add(Artist artist) {
        return artistRepository.save(artist);
    }

    public Long modify(Artist artist) {
        get(artist.getId());
        artistRepository.save(artist);
        return artist.getId();
    }

    public void remove(Long id) {
        get(id);
        if (albumRepository.existsByArtistId(id)) {
            throw new DataIntegrityViolationException("아티스트의 앨범이 존재하여 삭제할 수 없습니다..");
        }
        artistRepository.deleteById(id);
    }

}