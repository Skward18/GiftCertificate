package com.io.gift.mapper;

import com.io.gift.model.entity.GiftCertificate;
import com.io.gift.model.request.GiftCertificateCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface GiftCertificateCreateMapper {

    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "expiresAt", ignore = true)
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "id", ignore = true)
    GiftCertificate toEntity(GiftCertificateCreateRequest request);
}