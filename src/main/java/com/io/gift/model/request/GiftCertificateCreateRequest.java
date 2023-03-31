package com.io.gift.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;


@Data
public class GiftCertificateCreateRequest {

    @NotBlank
    private String name;

    private String description;

    @PositiveOrZero
    private Long price;

    @Positive
    private Integer durationInDays;

    @NotNull
    private TagCreateRequest tagCreateRequest;

}
