package com.io.gift.mapper.dto;

import com.io.gift.mapper.config.DtoMapper;
import com.io.gift.mapper.config.EntityMapper;
import com.io.gift.mapper.config.MapstructAutoWire;
import com.io.gift.model.dto.TagDto;
import com.io.gift.model.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(config = MapstructAutoWire.class)
public interface TagMapper extends DtoMapper<TagDto, Tag>, EntityMapper<Tag, TagDto> {
}
