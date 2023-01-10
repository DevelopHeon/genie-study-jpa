package com.hh.jpastudy.artitst.service;

import com.hh.jpastudy.artitst.entity.Artist;
import com.hh.jpastudy.artitst.form.ArtistForm.Request.Find;
import com.hh.jpastudy.artitst.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.hh.jpastudy.artitst.mapper.ArtistMapper.mapper;

/**
 * @since       2023.01.09
 * @author      sony
 * @description artist service
 **********************************************************************************************************************/
@Service
@Transactional
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;

    @Transactional(readOnly = true)
    public Page<Artist> getAll(Find find, Pageable pageable) {
        return artistRepository.findAll(find, pageable);
    }
    @Transactional(readOnly = true)
    public Artist get(Long id) {
        return artistRepository.findById(id).get();
    }

    public Artist add(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist modify(Artist artist) {
        return artistRepository.save(artist);
    }

    public void remove(Long id) {
        artistRepository.deleteById(id);
    }
}