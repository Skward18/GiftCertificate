package com.io.gift.model.request;

import lombok.Data;

@Data
public class GiftCertificateCreateRequest {

    private String name;
    private String description;
    private Long price;
    private Integer duration;

}
