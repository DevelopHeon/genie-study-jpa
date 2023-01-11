package com.hh.jpastudy.common.error;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @since       2023.01.11
 * @author      sony
 * @description resource not found exception
 **********************************************************************************************************************/
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}