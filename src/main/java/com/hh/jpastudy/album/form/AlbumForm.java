package com.hh.jpastudy.album.form;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @since       2023.01.09
 * @author      sony
 * @description album form
 **********************************************************************************************************************/
public class AlbumForm {

    public static class Request {
        @Getter
        @Setter
        @Builder
        @ToString
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Find {
            @Length(max = 100)
            private String title;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Add {

            @Valid
            private Artist artist;

            @NotBlank
            @Length(max = 100)
            private String title;

            @NotNull
            private LocalDate releaseDate;

            @Length(max = 100)
            private String genre;

            @Length(max = 1000)
            private String description;

            @Valid
            private List<SoundTrack> soundTracks = new ArrayList<>();

            @Getter
            @Setter
            @Builder
            @ToString
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Artist {

                @NotNull
                private Long id;

                @NotBlank
                private String name;
            }

            @Getter
            @Setter
            @Builder
            @ToString
            @NoArgsConstructor
            @AllArgsConstructor
            public static class SoundTrack {

                @NotNull
                private int orderNo;

                @NotBlank
                @Length(max = 100)
                private String title;

                @NotBlank
                private String playTime;

                @NotNull
                private Boolean exposure;

            }
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Modify {

            @Valid
            private Artist artist;

            @NotBlank
            @Length(max = 100)
            private String title;

            @NotNull
            private LocalDate releaseDate;

            @Length(max = 100)
            private String genre;

            @Length(max = 1000)
            private String description;

            @Valid
            private List<SoundTrack> soundTracks = new ArrayList<>();

            @Getter
            @Setter
            @Builder
            @ToString
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Artist{

                @NotNull
                private Long id;

                @NotBlank
                private String name;

            }

            @Getter
            @Setter
            @Builder
            @ToString
            @NoArgsConstructor
            @AllArgsConstructor
            public static class SoundTrack {

                @NotNull
                private int orderNo;

                @NotBlank
                @Length(max = 100)
                private String title;

                @NotBlank
                private String playTime;

                @NotNull
                private Boolean exposure;

            }
        }

    }

    public static class Response {
        @Data
        public static class FindOne {

            private Long id;
            private Artist artist;
            private String title;
            private LocalDate releaseDate;
            private String genre;
            private String description;
            private List<SoundTrack> soundTracks = new ArrayList<>();
            private String createdBy;
            private String lastModifiedBy;
            private LocalDateTime modifiedAt;
            private LocalDateTime createdAt;

            @Data
            public static class Artist {
                private Long id;
                private String name;
            }

            @Data
            public static class SoundTrack {
                private int orderNo;
                private String title;
                private String playTime;
                private Boolean exposure;
            }

        }

        @Data
        public static class FindAll {

            private Long id;
            private Artist artist;
            private String title;
            private LocalDate releaseDate;
            private String genre;
            private String description;
            private String createdBy;
            private String lastModifiedBy;
            private LocalDateTime modifiedAt;
            private LocalDateTime createdAt;

            @Data
            public static class Artist {
                private Long id;
                private String name;
            }

        }

    }

}