package com.io.gift.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.io.gift.model.entity.GiftCertificate;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link GiftCertificate} entity
 */
public record GiftCertificateDto(Long id,
                                 String name,
                                 String description,
                                 Long price,
                                 Integer duration,
                                 @JsonIgnore LocalDateTime createDate,
                                 @JsonIgnore LocalDateTime lastUpdateDate,
                                 @JsonIgnore LocalDateTime expiresAt) implements Serializable {
}