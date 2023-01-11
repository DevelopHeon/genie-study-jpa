package com.hh.jpastudy.album.controller;

import com.hh.jpastudy.album.form.AlbumForm.Request.Add;
import com.hh.jpastudy.album.form.AlbumForm.Request.Find;
import com.hh.jpastudy.album.form.AlbumForm.Request.Modify;
import com.hh.jpastudy.album.form.AlbumForm.Response.FindAll;
import com.hh.jpastudy.album.form.AlbumForm.Response.FindOne;
import com.hh.jpastudy.album.service.AlbumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


import static com.hh.jpastudy.album.mapper.AlbumMapper.mapper;

/**
 * @author sony
 * @description album controller
 * @since 2023.01.09
 **********************************************************************************************************************/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class AlbumController {
    private final AlbumService albumService;

    @GetMapping("/albums")
    public Page<FindAll> getAll(Find find, Pageable pageable) {
        return albumService.getAll(find, pageable).map(mapper::toFindAll);
    }

    @GetMapping("/albums/{id}")
    public FindOne get(@PathVariable Long id) {
        return mapper.toFindOne(albumService.get(id));
    }

    @PostMapping("/albums")
    public FindOne add(@Valid @RequestBody Add add) {
        return mapper.toFindOne(albumService.add(mapper.toAlbum(add)));
    }

    @PutMapping("/albums/{id}")
    public Long modify(@PathVariable Long id, @Valid @RequestBody Modify modify) {
        return albumService.modify(mapper.toAlbum(id, modify));
    }

    @DeleteMapping("/albums/{id}")
    public void remove(@PathVariable Long id) {
        albumService.remove(id);
    }
}