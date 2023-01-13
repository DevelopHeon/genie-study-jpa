package com.hh.jpastudy.album.form;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.CollectionUtils;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

/**
 * @author sony
 * @description album form
 * @since 2023.01.09
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
            @NotNull
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
            private List<SoundTrack> soundTracks;

            @Getter
            @Setter
            @Builder
            @ToString
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Artist {

                @NotNull
                private Long id;

            }

            @Getter
            @Setter
            @Builder
            @ToString
            @NoArgsConstructor
            @AllArgsConstructor
            public static class SoundTrack {

                @NotNull
                @Min(1)
                private Integer orderNo;

                @NotBlank
                @Length(max = 100)
                private String title;

                @NotBlank
                @Length(max = 10)
                private String playTime;

                @NotNull
                private Boolean exposure;

            }

            @AssertTrue(message = "음원의 순서는 중복될 수 없습니다.")
            public boolean isOrderDuplicateValidate() {
                if (CollectionUtils.isEmpty(soundTracks)) {
                    return true;
                }
                return soundTracks.stream().map(Add.SoundTrack::getOrderNo)
                        .allMatch(new HashSet<>()::add);
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
            @NotNull
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
            private List<SoundTrack> soundTracks;

            @Getter
            @Setter
            @Builder
            @ToString
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Artist {

                @NotNull
                private Long id;

            }

            @Getter
            @Setter
            @Builder
            @ToString
            @NoArgsConstructor
            @AllArgsConstructor
            public static class SoundTrack {

                @NotNull
                @Min(1)
                private Integer orderNo;

                @NotBlank
                @Length(max = 100)
                private String title;

                @NotBlank
                @Length(max = 10)
                private String playTime;

                @NotNull
                private Boolean exposure;

            }

            @AssertTrue(message = "음원의 순서는 중복될 수 없습니다.")
            public boolean isOrderDuplicateValidate() {
                if (CollectionUtils.isEmpty(soundTracks)) {
                    return true;
                }
                return soundTracks.stream().map(SoundTrack::getOrderNo)
                        .allMatch(new HashSet<>()::add);
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
            private List<SoundTrack> soundTracks;
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
                private Integer orderNo;
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