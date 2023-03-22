package com.io.gift.model.dto;

import com.io.gift.model.entity.Tag;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Tag} entity
 */
public record TagDto(Long id, String name) implements Serializable {
}