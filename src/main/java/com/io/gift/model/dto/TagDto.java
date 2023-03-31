package com.io.gift.model.dto;

import com.io.gift.model.entity.Tag;
import com.io.gift.model.request.RequestedTagStatus;

import java.io.Serializable;

/**
 * A DTO for the {@link Tag} entity
 */
public record TagDto(Long id,
                     String name) implements Serializable {
}