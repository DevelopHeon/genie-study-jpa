package com.hh.jpastudy.common.exception;

import com.hh.jpastudy.artitst.exception.ArtistByAlbumExistException;
import com.hh.jpastudy.common.exception.ExceptionForm.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author sony
 * @description api exception handler
 * @since 2023.01.11
 **********************************************************************************************************************/
@RestControllerAdvice
public class ExceptionsHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<?> handleNotFoundException(ResourceNotFoundException e) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ArtistByAlbumExistException.class)
    protected ResponseEntity<?> handleArtistByAlbumExist(ArtistByAlbumExistException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        List<ErrorResponse> errors = e.getFieldErrors().stream()
                .map(error -> new ErrorResponse(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        ExceptionForm exceptionForm = new ExceptionForm("유효성 검증에 실패하였습니다.", LocalDateTime.now(), errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionForm);
    }
}