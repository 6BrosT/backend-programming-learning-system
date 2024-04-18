package com.backend.programming.learning.system.core.service.dataaccess.topic.repository;

import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TopicJpaRepository extends JpaRepository<TopicEntity, UUID> {
    Optional<TopicEntity> findById(UUID id);

    @Transactional
    @Modifying
    @Query("update TopicEntity t set t.name = ?1, t.description = ?2 where t.id = ?3")
    int updateNameAndDescriptionById(String name, String description, UUID id);
}
