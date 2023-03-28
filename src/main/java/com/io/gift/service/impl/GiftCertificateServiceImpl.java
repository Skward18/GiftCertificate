package com.io.gift.service.impl;

import com.io.gift.mapper.GiftCertificateCreateMapper;
import com.io.gift.mapper.GiftCertificateMapper;
import com.io.gift.mapper.TagMapper;
import com.io.gift.model.dto.GiftCertificateDto;
import com.io.gift.model.entity.GiftCertificate;
import com.io.gift.model.entity.Tag;
import com.io.gift.model.request.GiftCertificateCreateRequest;
import com.io.gift.model.request.RequestedTagStatus;
import com.io.gift.repository.GiftCertificateRepository;
import com.io.gift.repository.TagRepository;
import com.io.gift.service.GiftCertificateService;
import com.io.gift.service.TagService;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class GiftCertificateServiceImpl implements GiftCertificateService {

    private final TagService tagService;
    private final TagMapper tagMapper;
    private final GiftCertificateMapper giftCertificateMapper;
    private final GiftCertificateRepository giftCertificateRepository;
    private final GiftCertificateCreateMapper giftCertificateCreateMapper;

    @Override
    public GiftCertificateDto create(GiftCertificateCreateRequest request) {
        log.info("Saving gift certificate... ");
        GiftCertificate giftCertificate = giftCertificateCreateMapper.toEntity(request);

        List<Tag> tags = tagMapper.toEntityList(tagService.create(request.getTagCreateRequest()));

        giftCertificate.setTags(tags);
        giftCertificate.setCreateDate(LocalDateTime.now());
        giftCertificate.setLastUpdateDate(LocalDateTime.now());
        giftCertificate.setExpiresAt(LocalDateTime.now().plusDays(request.getDurationInDays()));
        giftCertificateRepository.save(giftCertificate);
        return giftCertificateMapper.toDto(giftCertificate);
    }

    @Override
    public GiftCertificateDto getOne(Long id) {
        log.info("Searching for certificate by id = {}", id);
        return giftCertificateMapper.toDto(giftCertificateRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }

}
