package com.io.gift.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_gift_certificates")
public class GiftCertificate extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private Integer duration;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "gift_certificate_id", referencedColumnName = "id")
    private List<Tag> tag;

    // TODO: 15.03.2023 manytomany tag list, no cascade


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GiftCertificate that = (GiftCertificate) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }
}
