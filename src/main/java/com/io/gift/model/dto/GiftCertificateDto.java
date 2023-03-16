package com.io.gift.model.dto;

import com.io.gift.model.entity.GiftCertificate;
import com.io.gift.model.entity.Tag;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link GiftCertificate} entity
 */
public record GiftCertificateDto(Long id,
                                 String name,
                                 String description,
                                 Long price,
                                 Integer duration,
                                 LocalDateTime createDate,
                                 LocalDateTime lastUpdateDate,
                                 LocalDateTime expiresAt,
                                 List<Tag> tagList) implements Serializable {
}