package com.io.gift.repository;

import com.io.gift.model.entity.GiftCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GiftCertificateRepository extends JpaRepository<GiftCertificate, Long> {

    Boolean existsByNameAndIsEnabledTrue(String name);
    Optional<GiftCertificate> findByName(String name);
}