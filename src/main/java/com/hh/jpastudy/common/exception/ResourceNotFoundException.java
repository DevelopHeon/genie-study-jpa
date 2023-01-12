package com.hh.jpastudy.common.exception;

/**
 * @since       2023.01.11
 * @author      sony
 * @description resource not found exception
 **********************************************************************************************************************/
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}