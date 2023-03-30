package com.io.gift.controller.config;

import com.io.gift.model.request.GiftCertificateCreateRequest;
import com.io.gift.model.request.TagCreateRequest;
import com.io.gift.repository.TagRepository;
import com.io.gift.service.GiftCertificateService;
import com.io.gift.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.hibernate.mapping.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hibernate.Hibernate.map;

@Component
@Profile("test")
@RequiredArgsConstructor
public class CommandLineRunnerConfig implements CommandLineRunner {


    private Integer giftCertificate;
    private Integer tags;

    private final GiftCertificateService giftCertificateService;
    private final TagService tagService;
    private final TagRepository tagRepository;

    @Override
    public void run(String... args) throws Exception {
        createGiftCertificate();
        createTags();
    }

    private void createGiftCertificate(){
        for (int i = 1; i<= giftCertificate; i++) {
            GiftCertificateCreateRequest request = new GiftCertificateCreateRequest();
            request.setName("Certificate №" + i);
            request.setDescription("Description for " + (request.getName()) + "with №" + i);
            request.setPrice((long) (100 * i));
            request.setDurationInDays(i);
            request.setTagCreateRequest();
        }
    }

    private void createTags() {
        for(int i = 1; i<= tags; i++) {
            TagCreateRequest request = new TagCreateRequest();
            map(() -> request.setTags("string", "new"));
        }
    }
}