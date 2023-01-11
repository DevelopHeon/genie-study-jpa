package com.hh.jpastudy.common.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @since       2023.01.11
 * @author      sony
 * @description api exception handler
 **********************************************************************************************************************/
@RestControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<?> handleNotFoundException(ResourceNotFoundException e) {
        ExceptionForm exceptionForm = ExceptionForm.builder()
                .message(e.getMessage())
                .exceptionCode("400 ERROR")
                .build();

        return new ResponseEntity<>(exceptionForm, HttpStatus.NOT_FOUND);
    }
}