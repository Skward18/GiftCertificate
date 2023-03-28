package com.io.gift.controller;

import com.io.gift.model.dto.TagDto;
import com.io.gift.model.request.TagCreateRequest;
import com.io.gift.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tags")
public class TagController {

    private final TagService tagService;

    @PostMapping
    public ResponseEntity<List<TagDto>> create(@RequestBody TagCreateRequest tagCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(tagService.create(tagCreateRequest));
    }

    @GetMapping
    private List<TagDto> getAll(){
        return tagService.getAll();
    }
}
