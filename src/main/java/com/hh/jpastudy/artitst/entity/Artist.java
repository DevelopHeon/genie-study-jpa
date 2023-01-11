package com.hh.jpastudy.artitst.entity;

import com.hh.jpastudy.common.entity.Base;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @since       2023.01.09
 * @author      sony
 * @description artist
 **********************************************************************************************************************/
@Entity(name = "artist")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Artist extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(length = 100)
    private String agency;

    @Column(nullable = false)
    private String nationality;

    @Column(length = 1000)
    private String description;

}