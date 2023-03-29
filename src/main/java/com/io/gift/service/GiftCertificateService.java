package com.io.gift.service;

import com.io.gift.model.dto.GiftCertificateDto;
import com.io.gift.model.request.GiftCertificateCreateRequest;
import com.io.gift.model.request.GiftCertificateUpdateMapper;

public interface GiftCertificateService {

    GiftCertificateDto create(GiftCertificateCreateRequest giftCertificateCreateRequest);
    GiftCertificateDto getOne(Long id);

    GiftCertificateDto updateOne(GiftCertificateUpdateMapper request, Long id);

    GiftCertificateDto deleteOneById(Long id);
    GiftCertificateDto deleteOneByName(String name);

    GiftCertificateDto entirelyDelete(Long id);
}
