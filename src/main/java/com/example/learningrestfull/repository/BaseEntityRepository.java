package com.example.learningrestfull.repository;

import com.example.learningrestfull.model.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.UUID;

@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity> extends JpaRepository<T, UUID> {
    @Transactional
    default void softDelete(UUID uuid) {
        this.findById(uuid).ifPresent(
                entity -> {
                    entity.setDeletedAt(OffsetDateTime.now());
                    this.save(entity);
                });
    }
}
