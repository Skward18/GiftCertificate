package com.io.gift.service.impl;

import com.io.gift.exception.GiftCertificateIsNotEnabledException;
import com.io.gift.mapper.request.GiftCertificateCreateMapper;
import com.io.gift.mapper.dto.GiftCertificateMapper;
import com.io.gift.mapper.dto.TagMapper;
import com.io.gift.model.request.GiftCertificateUpdateMapper;
import com.io.gift.model.dto.GiftCertificateDto;
import com.io.gift.model.entity.GiftCertificate;
import com.io.gift.model.entity.Tag;
import com.io.gift.model.request.GiftCertificateCreateRequest;
import com.io.gift.repository.GiftCertificateRepository;
import com.io.gift.service.GiftCertificateService;
import com.io.gift.service.TagService;
import jakarta.persistence.EntityNotFoundException;
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
    private final GiftCertificateUpdateMapper giftCertificateUpdateMapper;

    @Override
    public GiftCertificateDto create(GiftCertificateCreateRequest request) {
        log.info("Creating gift certificate... ");
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

    @Override
    public GiftCertificateDto updateOne(GiftCertificateUpdateMapper request, Long id) {
        if (!giftCertificateRepository.existsById(id)) {
            throw new EntityNotFoundException("Gift Certificate by id = " + " not found");
        }
        GiftCertificate giftCertificate = giftCertificateUpdateMapper.toEntity(request);
        return giftCertificateMapper.toDto(giftCertificateRepository.save(giftCertificate));
    }

    @Override
    public GiftCertificateDto deleteOneById(Long id) {
        return giftCertificateMapper.toDto(giftCertificateRepository.findById(id).map(n -> {
            if (!n.getIsEnabled()) {
                throw new GiftCertificateIsNotEnabledException();
            }
            n.setIsEnabled(false);
            return giftCertificateRepository.save(n);
        }).orElseThrow(() -> new EntityNotFoundException("Gift Certificate by id = " + id + " not found")));
    }

    @Override
    public GiftCertificateDto deleteOneByName(String name) {
        return giftCertificateMapper.toDto(giftCertificateRepository.findByName(name).map(n -> {
            if (!n.getIsEnabled()) {
                throw new GiftCertificateIsNotEnabledException()Exception();
            }
            n.setIsEnabled(false);
            return giftCertificateRepository.save(n);
        }).orElseThrow(() -> new EntityNotFoundException("Gift Certificate by name = " + name + " not found")));
    }

    @Override
    public GiftCertificateDto entirelyDelete(Long id) {
        GiftCertificate giftCertificate = giftCertificateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gift Certificate by id = " + id + " not found"));
        giftCertificateRepository.deleteById(id);
        return giftCertificateMapper.toDto(giftCertificate);
    }

}
