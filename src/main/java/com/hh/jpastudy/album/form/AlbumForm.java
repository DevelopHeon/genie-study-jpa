package com.hh.jpastudy.album.form;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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
            private String name;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Add {

            @NotNull
            private Artist artist;
            @NotBlank
            private String name;
            @NotNull
            private LocalDate releaseDate;
            private String genre;
            private String description;
            private List<SoundTrack> soundTracks = new ArrayList<>();
            @Getter
            @Setter
            @Builder
            @ToString
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Artist {

                private Long id;

                private String name;
            }

            @Getter
            @Setter
            @Builder
            @ToString
            @NoArgsConstructor
            @AllArgsConstructor
            public static class SoundTrack {
                private int orderNo;
                private String name;
                private String playTime;
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
            private Artist artist;
            private String name;
            private LocalDate releaseDate;
            private String genre;
            private String description;
            private List<SoundTrack> soundTracks = new ArrayList<>();

            @Getter
            @Setter
            @Builder
            @ToString
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Artist{
                private Long id;
                private String name;
            }

            @Getter
            @Setter
            @Builder
            @ToString
            @NoArgsConstructor
            @AllArgsConstructor
            public static class SoundTrack {
                private int orderNo;
                private String name;
                private String playTime;
                private Boolean exposure;
            }
        }

    }

    public static class Response {
        @Data
        public static class FindOne {

            private Long id;
            private Artist artist;
            private String name;
            private LocalDate releaseDate;
            private String genre;
            private String description;
            private List<SoundTrack> soundTracks = new ArrayList<>();
            private String createdBy;
            private String createdAt;

            @Data
            public static class Artist {
                private Long id;
                private String name;
            }

            @Data
            public static class SoundTrack {
                private int orderNo;
                private String name;
                private String playTime;
                private Boolean exposure;
            }

        }

        @Data
        public static class FindAll {

            private Artist artist;
            private String name;
            private LocalDate releaseDate;
            private String genre;
            private String description;
            private String createdBy;
            private String createdAt;
            @Data
            public static class Artist {
                private Long id;
                private String name;
            }

        }

    }

}