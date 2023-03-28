package com.io.gift.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;


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

    private String description;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "certificate_has_tag",
            joinColumns = @JoinColumn(name = "certificate_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private List<Tag> tags;

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
