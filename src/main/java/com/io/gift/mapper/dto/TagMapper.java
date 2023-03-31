package com.io.gift.mapper.dto;

import com.io.gift.mapper.config.DtoMapper;
import com.io.gift.mapper.config.EntityMapper;
import com.io.gift.mapper.config.MapstructAutoWire;
import com.io.gift.model.dto.TagDto;
import com.io.gift.model.entity.Tag;
import org.mapstruct.Mapper;

@Mapper(config = MapstructAutoWire.class)

public interface TagMapper extends DtoMapper<TagDto, Tag>, EntityMapper<Tag, TagDto> {
}
