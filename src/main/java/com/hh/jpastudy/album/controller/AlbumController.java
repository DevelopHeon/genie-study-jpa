package com.hh.jpastudy.album.controller;

import com.hh.jpastudy.album.form.AlbumForm.Request.Add;
import com.hh.jpastudy.album.form.AlbumForm.Response.FindOne;
import com.hh.jpastudy.album.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.hh.jpastudy.album.mapper.AlbumMapper.mapper;

/**
 * @since       2023.01.09
 * @author      sony
 * @description album controller
 **********************************************************************************************************************/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AlbumController {

    private final AlbumService albumService;
    @PostMapping("/albums")
    public FindOne add(@Valid @RequestBody Add add) {
        return mapper.toFindOne(albumService.add(mapper.toAlbum(add)));
    }
}