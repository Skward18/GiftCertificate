package com.io.gift.service.impl;

import com.io.gift.mapper.GiftCertificateCreateMapper;
import com.io.gift.mapper.GiftCertificateMapper;
import com.io.gift.model.dto.GiftCertificateDto;
import com.io.gift.model.entity.GiftCertificate;
import com.io.gift.model.request.GiftCertificateCreateRequest;
import com.io.gift.repository.GiftCertificateRepository;
import com.io.gift.service.GiftCertificateService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Slf4j
@Service
@RequiredArgsConstructor
public class GiftCertificateServiceImpl implements GiftCertificateService {
    private final GiftCertificateMapper giftCertificateMapper;
    private final GiftCertificateRepository giftCertificateRepository;
    private final GiftCertificateCreateMapper giftCertificateCreateMapper;

    @Override
    public GiftCertificateDto create(GiftCertificateCreateRequest request) {
        log.info("Saving gift certificate... ");
        GiftCertificate giftCertificate = giftCertificateCreateMapper.toEntity(request);
        giftCertificate.setDuration(request.getDuration());
        giftCertificate.setCreateDate(LocalDateTime.now());
        giftCertificate.setLastUpdateDate(LocalDateTime.now());
        giftCertificate.setExpiresAt(LocalDateTime.now().plusDays(request.getDuration()));
        giftCertificateRepository.save(giftCertificate);
        return giftCertificateMapper.toDto(giftCertificate);
    }

    @Override
    public GiftCertificateDto getOne(Long id) {
        log.info("Searching for certificate by id = {}", id);
        return giftCertificateMapper.toDto(giftCertificateRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }

    // TODO: 15.03.2023 create request in method create: name, description, price.
}
