package com.io.gift.controller;

import com.io.gift.model.dto.GiftCertificateDto;
import com.io.gift.model.request.GiftCertificateCreateRequest;
import com.io.gift.model.request.GiftCertificateUpdateMapper;
import com.io.gift.service.GiftCertificateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/giftCertificate")
public class GiftCertificateController {

    private final GiftCertificateService giftCertificateService;

    @PostMapping
    public ResponseEntity<GiftCertificateDto> create(@RequestBody @Valid GiftCertificateCreateRequest giftCertificateCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(giftCertificateService.create(giftCertificateCreateRequest));
    }

    @GetMapping("/{id}")
    public GiftCertificateDto getOne(@PathVariable Long id) {
        return giftCertificateService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GiftCertificateDto> updateOne(@RequestBody GiftCertificateUpdateMapper request,
                                                        @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(giftCertificateService.updateOne(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GiftCertificateDto> deleteOneById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(giftCertificateService.deleteOneById(id));
    }
    @DeleteMapping(params = {"name"})
    public ResponseEntity<GiftCertificateDto> deleteOneByName(@RequestBody String name) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(giftCertificateService.deleteOneByName(name));
    }
    }