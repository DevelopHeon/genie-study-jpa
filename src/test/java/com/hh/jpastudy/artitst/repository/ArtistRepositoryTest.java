package com.hh.jpastudy.artitst.repository;

import com.hh.jpastudy.album.repository.AlbumRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ArtistRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Test
    void existsByAlbumIdTest() {
        Boolean result = albumRepository.existsByArtistId(1L);
        Assertions.assertThat(result).isTrue();
    }

}