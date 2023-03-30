package com.io.gift.service;

import com.io.gift.model.dto.TagDto;
import com.io.gift.model.request.TagCreateRequest;

import java.util.List;

public interface TagService {

    List<TagDto> create(TagCreateRequest tagCreateRequest);
    List<TagDto> getAll();

    TagDto deleteOne(Long id);
    TagDto deleteOne(String name);
}
