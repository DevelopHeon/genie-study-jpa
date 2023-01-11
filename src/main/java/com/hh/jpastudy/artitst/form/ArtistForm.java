package com.hh.jpastudy.artitst.form;

import com.hh.jpastudy.artitst.enumerate.Agency;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author sony
 * @description artist form
 * @since 2023.01.09
 **********************************************************************************************************************/
public class ArtistForm {

    public static class Request {
        @Getter
        @Setter
        @Builder
        @ToString
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Find {
            @Length(max = 100)
            private String name;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Add {

            @Length(max = 100)
            @NotBlank
            private String name;

            @NotNull
            private LocalDate birth;

            private Agency agency;

            @Length(max = 255)
            @NotBlank
            private String nationality;

            @Length(max = 1000)
            private String description;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Modify {
            @Length(max = 100)
            @NotBlank
            private String name;

            @NotNull
            private LocalDate birth;

            private Agency agency;

            @Length(max = 255)
            @NotBlank
            private String nationality;

            @Length(max = 1000)
            private String description;
        }

    }

    public static class Response {
        @Data
        public static class FindAll {

            private Long id;
            private String name;
            private LocalDate birth;
            private Agency agency;
            private String nationality;
            private String description;
            private String createdBy;
            private String lastModifiedBy;
            private LocalDateTime modifiedAt;
            private LocalDateTime createdAt;

        }

        @Data
        public static class FindOne {

            private Long id;
            private String name;
            private LocalDate birth;
            private Agency agency;
            private String nationality;
            private String description;
            private String createdBy;
            private String lastModifiedBy;
            private LocalDateTime modifiedAt;
            private LocalDateTime createdAt;
        }
    }

}