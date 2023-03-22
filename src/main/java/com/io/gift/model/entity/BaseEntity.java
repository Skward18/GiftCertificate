package com.io.gift.model.entity;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity extends AbstractPersistable<Long> {

    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;

}
