package com.io.gift.mapper.request;

import com.io.gift.mapper.config.MapstructAutoWire;
import com.io.gift.model.entity.Tag;
import com.io.gift.model.request.TagCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructAutoWire.class)
public interface TagCreateMapper {

    @Override
    Tag toEntity(TagCreateRequest dto);
}
