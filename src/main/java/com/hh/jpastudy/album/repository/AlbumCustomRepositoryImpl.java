package com.hh.jpastudy.album.repository;

import com.hh.jpastudy.album.entity.Album;
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
                .innerJoin(album.artist, artist)
                .fetchJoin()
                .where(eqName(find))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(album.id.desc())
                .fetch();

        return new PageImpl<>(query, pageable, query.stream().count());
    }

    @Override
    public Optional<Album> findByAlbumWithTrack(Long id) {
        Album query = jpaQueryFactory.selectFrom(album)
                .innerJoin(album.artist, artist)
                .fetchJoin()
                .leftJoin(album.soundTracks, soundTrack)
                .fetchJoin()
                .where(album.id.eq(id))
                .orderBy(soundTrack.orderNo.asc())
                .fetchOne();

        return Optional.ofNullable(query);
    }

    private BooleanExpression eqName(Find find) {
        if (StringUtils.hasText(find.getTitle())) {
            return album.title.contains(find.getTitle());
        }
        return null;
    }
}