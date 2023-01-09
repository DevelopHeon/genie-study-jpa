package com.hh.jpastudy.album.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/**
 * @since       2023.01.09
 * @author      sony
 * @description sound track
 **********************************************************************************************************************/
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SoundTrack {
    @Column(nullable = false)
    private int orderNo;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private String playTime;
    @Column(nullable = false)
    private Boolean exposure;
}