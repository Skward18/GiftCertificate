package com.io.gift.model.request;

import lombok.Data;

import java.util.List;

@Data
public class TagCreateRequest {
    private List<String> tags;

}
