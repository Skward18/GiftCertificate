package com.io.gift.mapper;

import com.io.gift.model.dto.GiftCertificateDto;
import com.io.gift.model.entity.GiftCertificate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface GiftCertificateMapper {

    GiftCertificateDto toDto(GiftCertificate giftCertificate);
}
