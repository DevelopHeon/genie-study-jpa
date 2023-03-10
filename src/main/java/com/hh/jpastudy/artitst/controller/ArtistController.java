package com.hh.jpastudy.artitst.controller;

import com.hh.jpastudy.artitst.form.ArtistForm.Request.Add;
import com.hh.jpastudy.artitst.form.ArtistForm.Request.Find;
import com.hh.jpastudy.artitst.form.ArtistForm.Request.Modify;
import com.hh.jpastudy.artitst.form.ArtistForm.Response.FindAll;
import com.hh.jpastudy.artitst.form.ArtistForm.Response.FindOne;
import com.hh.jpastudy.artitst.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.hh.jpastudy.artitst.mapper.ArtistMapper.mapper;

/**
 * @since       2023.01.09
 * @author      sony
 * @description artist controller
 **********************************************************************************************************************/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping("/artists")
    public Page<FindAll> getAll(@Valid Find find, Pageable pageable) {
        return artistService.getAll(find, pageable).map(mapper::toFindAll);
    }

    @GetMapping("/artists/{id}")
    public FindOne get(@PathVariable Long id) {
        return mapper.toFindOne(artistService.get(id));
    }

    @PostMapping("/artists")
    public Long add(@Valid @RequestBody Add add) {
        return artistService.add(mapper.toArtist(add));
    }

    @PutMapping("/artists/{id}")
    public Long modify(@PathVariable Long id, @Valid @RequestBody Modify modify) {
        return artistService.modify(mapper.toArtist(id, modify));
    }

    @DeleteMapping("/artists/{id}")
    public void remove(@PathVariable Long id) {
        artistService.remove(id);
    }
}