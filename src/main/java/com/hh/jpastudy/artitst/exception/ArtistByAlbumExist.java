package com.hh.jpastudy.artitst.exception;
/**
 * @since       2023.01.11
 * @author      sony
 * @description resource not found exception
 **********************************************************************************************************************/
public class ArtistByAlbumExist extends RuntimeException{
    public ArtistByAlbumExist(String message) {
        super(message);
    }
}
