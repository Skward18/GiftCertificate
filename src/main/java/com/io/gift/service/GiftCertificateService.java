package com.io.gift.service;

import com.io.gift.model.dto.GiftCertificateDto;
import com.io.gift.model.request.GiftCertificateCreateRequest;
import com.io.gift.model.request.GiftCertificateUpdateRequest;

public interface GiftCertificateService {

    GiftCertificateDto create(GiftCertificateCreateRequest giftCertificateCreateRequest);
    GiftCertificateDto getOne(Long id);

    GiftCertificateDto updateOne(GiftCertificateUpdateRequest request, Long id);

    GiftCertificateDto deleteOne(Long id);
    GiftCertificateDto deleteOne(String name);
    GiftCertificateDto entirelyDelete(Long id);
}
