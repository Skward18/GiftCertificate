package com.io.gift.model.entity;


import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;



@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public abstract class BaseEntity extends AbstractPersistable<Long>{

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;

}
