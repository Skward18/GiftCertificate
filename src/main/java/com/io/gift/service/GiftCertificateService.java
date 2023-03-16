package com.io.gift.service;

import com.io.gift.model.dto.GiftCertificateDto;
import com.io.gift.model.entity.GiftCertificate;
import com.io.gift.model.request.GiftCertificateCreateRequest;

public interface GiftCertificateService {

    GiftCertificateDto create(GiftCertificateCreateRequest giftCertificateCreateRequest);
    GiftCertificateDto getOne(Long id);
}
