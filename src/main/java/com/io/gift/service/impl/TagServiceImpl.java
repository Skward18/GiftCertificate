package com.io.gift.service.impl;

import com.io.gift.mapper.dto.TagMapper;
import com.io.gift.model.dto.TagDto;
import com.io.gift.model.entity.Tag;
import com.io.gift.model.request.RequestedTagStatus;
import com.io.gift.model.request.TagCreateRequest;
import com.io.gift.repository.TagRepository;
import com.io.gift.service.TagService;
import java.util.ArrayList;
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
        List<Tag> newTags = new ArrayList<>();
        List<String> existingTags = new ArrayList<>();

        tagCreateRequest.getTags().forEach((tagName, requestedTagStatus) -> {
            if (requestedTagStatus.equals(RequestedTagStatus.NEW)) {
                newTags.add(Tag.builder().name(tagName).build());
            }
            else {
                existingTags.add(tagName);
            }
        });

        List<Tag> tags = tagRepository.saveAll(newTags);
        tags.addAll(tagRepository.findAllByNameIn(existingTags));
        return tagMapper.toDtoList(tags);
    }

    @Override
    public List<TagDto> getAll() {
        log.info("Getting all");
        return tagMapper.toDtoList(tagRepository.findAll());
    }

    @Override
    public TagDto deleteOne(Long id) {
        return null;
    }

    @Override
    public TagDto deleteOne(String name) {
        return null;
    }
}
