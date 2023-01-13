package com.hh.jpastudy.artitst.repository;

import com.hh.jpastudy.artitst.entity.Artist;
import com.hh.jpastudy.artitst.form.ArtistForm.Request.Find;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.hh.jpastudy.artitst.entity.QArtist.artist;

/**
 * @since       2023.01.09
 * @author      sony
 * @description artist custom repository impl
 **********************************************************************************************************************/
@RequiredArgsConstructor
public class ArtistCustomRepositoryImpl implements ArtistCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Artist> findAll(Find find, Pageable pageable) {

        List<Artist> query = jpaQueryFactory.selectFrom(artist)
                .where(containsName(find.getName()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(artist.id.desc())
                .fetch();

        return new PageImpl<>(query, pageable, query.stream().count());
    }

    private BooleanExpression containsName(String name) {

        if (StringUtils.hasText(name)){
            return artist.name.contains(name);
        }
        return null;
    }
}