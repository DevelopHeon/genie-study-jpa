package com.hh.jpastudy.album.repository;

import com.hh.jpastudy.album.entity.Album;
import com.hh.jpastudy.album.entity.QSoundTrack;
import com.hh.jpastudy.album.form.AlbumForm.Request.Find;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

import static com.hh.jpastudy.album.entity.QAlbum.album;
import static com.hh.jpastudy.album.entity.QSoundTrack.soundTrack;
import static com.hh.jpastudy.artitst.entity.QArtist.artist;

/**
 * @since       2023.01.10
 * @author      sony
 * @description album custom repository impl
 **********************************************************************************************************************/
@RequiredArgsConstructor
public class AlbumCustomRepositoryImpl implements AlbumCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Album> findAll(Find find, Pageable pageable) {
        List<Album> query = jpaQueryFactory.selectFrom(album)
                .join(artist)
                .on(album.artist.id.eq(artist.id))
                .where(eqName(find))
                .orderBy(album.id.desc())
                .fetch();

        return new PageImpl<>(query, pageable, query.stream().count());
    }

    private BooleanExpression eqName(Find find) {
        if (StringUtils.hasText(find.getName())) {
            return album.name.contains(find.getName());
        }
        return null;
    }
}