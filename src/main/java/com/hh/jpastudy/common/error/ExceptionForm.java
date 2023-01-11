package com.hh.jpastudy.common.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @since       2023.01.11
 * @author      sony
 * @description exception form
 **********************************************************************************************************************/
@Getter
@Setter
@Builder
@AllArgsConstructor
public class ExceptionForm {
    private String message;
    private String exceptionCode;
}