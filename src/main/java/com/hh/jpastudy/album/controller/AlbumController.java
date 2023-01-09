package com.hh.jpastudy.album.controller;

import com.hh.jpastudy.album.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}