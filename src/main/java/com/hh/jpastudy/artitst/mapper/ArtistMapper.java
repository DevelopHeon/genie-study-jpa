package com.hh.jpastudy.artitst.mapper;

import com.hh.jpastudy.artitst.entity.Artist;
import com.hh.jpastudy.artitst.form.ArtistForm.Request.Add;
import com.hh.jpastudy.artitst.form.ArtistForm.Request.Modify;
import com.hh.jpastudy.artitst.form.ArtistForm.Response.FindAll;
import com.hh.jpastudy.artitst.form.ArtistForm.Response.FindOne;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * @author sony
 * @description artist mapper
 * @since 2023.01.09
 **********************************************************************************************************************/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArtistMapper {
    ArtistMapper mapper = Mappers.getMapper(ArtistMapper.class);
    FindOne toFindOne(Artist entity);
    FindAll toFindAll(Artist entity);
    Artist toArtist(Add form);
    Artist toArtist(Long id, Modify form);
    @Mapping(target = "id", ignore = true)
    Artist modify(Artist source, @MappingTarget Artist target);
}