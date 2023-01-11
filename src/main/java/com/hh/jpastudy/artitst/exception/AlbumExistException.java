package com.hh.jpastudy.artitst.exception;


/**
 * @since       2023.01.11
 * @author      sony
 * @description album exist exception
 **********************************************************************************************************************/
public class AlbumExistException extends RuntimeException{
    public AlbumExistException(String message) {
        super(message);
    }
}