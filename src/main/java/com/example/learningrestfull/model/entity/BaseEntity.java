package com.example.learningrestfull.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Where(clause = "deleted_at is null")
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    UUID uuid;

    @Column(nullable = false)
    @NotNull
    OffsetDateTime createdAt = OffsetDateTime.now();

    @Column
    @Nullable
    OffsetDateTime deletedAt = null;
}
