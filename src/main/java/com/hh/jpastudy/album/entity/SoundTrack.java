package com.hh.jpastudy.album.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @since       2023.01.09
 * @author      sony
 * @description sound track
 **********************************************************************************************************************/
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
@ToString
public class SoundTrack {

    @Column(nullable = false)
    private int orderNo;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String playTime;

    @Column(nullable = false)
    private Boolean exposure;

}