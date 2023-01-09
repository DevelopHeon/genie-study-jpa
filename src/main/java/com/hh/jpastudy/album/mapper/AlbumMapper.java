package com.hh.jpastudy.album.mapper;

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

}