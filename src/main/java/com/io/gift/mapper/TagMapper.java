package com.io.gift.mapper;

import com.io.gift.model.dto.TagDto;
import com.io.gift.model.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface TagMapper {
    TagDto toDto(Tag tag);

    List<TagDto> toDtoList(List<Tag> tag);
}
