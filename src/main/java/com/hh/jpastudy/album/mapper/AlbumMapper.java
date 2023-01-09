package com.hh.jpastudy.album.mapper;

import com.hh.jpastudy.album.entity.Album;
import com.hh.jpastudy.album.form.AlbumForm;
import com.hh.jpastudy.album.form.AlbumForm.Request.Add;
import com.hh.jpastudy.album.form.AlbumForm.Response.FindOne;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @since       2023.01.09
 * @author      sony
 * @description album mapper
 **********************************************************************************************************************/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AlbumMapper {

    AlbumMapper mapper = Mappers.getMapper(AlbumMapper.class);

    Album toAlbum(Add form);
    FindOne toFindOne(Album entity);
}