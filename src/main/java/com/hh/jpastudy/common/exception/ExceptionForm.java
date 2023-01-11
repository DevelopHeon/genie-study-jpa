package com.hh.jpastudy.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @since       2023.01.11
 * @author      sony
 * @description exception form
 **********************************************************************************************************************/
@Getter
@AllArgsConstructor
public class ExceptionForm {

    private String message;
    private LocalDateTime timestamp;
    private List<ErrorResponse> errors;

    @Getter
    @AllArgsConstructor
    public static class ErrorResponse {

        private String field;

        private String message;
    }

}