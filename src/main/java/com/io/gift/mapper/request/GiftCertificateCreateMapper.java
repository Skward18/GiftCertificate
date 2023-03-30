package com.io.gift.mapper.request;

import com.io.gift.mapper.config.EntityMapper;
import com.io.gift.mapper.config.MapstructAutoWire;
import com.io.gift.model.entity.GiftCertificate;
import com.io.gift.model.request.GiftCertificateCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(config = MapstructAutoWire.class)
public interface GiftCertificateCreateMapper extends EntityMapper<GiftCertificate, GiftCertificateCreateRequest> {

    @Override
    @Mapping(target = "isEnabled", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "expiresAt", ignore = true)
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "id", ignore = true)
    GiftCertificate toEntity(GiftCertificateCreateRequest request);
}