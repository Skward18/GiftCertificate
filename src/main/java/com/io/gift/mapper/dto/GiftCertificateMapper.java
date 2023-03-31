package com.io.gift.mapper.dto;

import com.io.gift.mapper.config.DtoMapper;
import com.io.gift.mapper.config.EntityMapper;
import com.io.gift.mapper.config.MapstructAutoWire;
import com.io.gift.model.dto.GiftCertificateDto;
import com.io.gift.model.entity.GiftCertificate;
import org.mapstruct.Mapper;

@Mapper(config = MapstructAutoWire.class)
public interface GiftCertificateMapper extends DtoMapper<GiftCertificateDto, GiftCertificate>, EntityMapper<GiftCertificate, GiftCertificateDto> {
}
