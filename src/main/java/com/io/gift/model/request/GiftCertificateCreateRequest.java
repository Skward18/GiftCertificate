package com.io.gift.model.request;

import com.io.gift.model.entity.Tag;
import lombok.Data;

import java.util.List;

@Data
public class GiftCertificateCreateRequest {

    private String name;
    private String description;
    private Long price;
    
    private List<Tag> tag;

}
