package com.io.gift.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.io.gift.model.entity.GiftCertificate;
import com.io.gift.model.request.RequestedTagStatus;

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
                                 LocalDateTime expiresAt,
                                 List<TagDto> tags,
                                 @JsonIgnore Boolean isEnabled,
                                 @JsonIgnore LocalDateTime createDate,
                                 @JsonIgnore LocalDateTime lastUpdateDate) implements Serializable {
}