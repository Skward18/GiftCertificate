package com.io.gift.model.request;

import com.io.gift.model.entity.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.List;

@Data
public class GiftCertificateUpdateRequest {

    @Positive
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @PositiveOrZero
    private Long price;

    @NotNull
    private List<Tag> tags;
}
