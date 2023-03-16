package com.io.gift.service.impl;

import com.io.gift.mapper.TagMapper;
import com.io.gift.model.dto.TagDto;
import com.io.gift.model.entity.Tag;
import com.io.gift.model.request.TagCreateRequest;
import com.io.gift.repository.TagRepository;
import com.io.gift.service.TagService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagMapper tagMapper;
    private final TagRepository tagRepository;


    @Override
    public List<TagDto> create(TagCreateRequest tagCreateRequest) {
        log.info("Saving tags... ");
        List<Tag> tags = tagRepository.saveAll(tagCreateRequest.getTags().stream().map(tagName -> {
            Tag tag = new Tag();
            tag.setName(tagName);
            return tag;
        }).toList());
        return tagMapper.toDtoList(tags);
    }

    @Override
    public TagDto getOne(Long id) {
        log.info("success");
        return tagMapper.toDto(tagRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }
}
