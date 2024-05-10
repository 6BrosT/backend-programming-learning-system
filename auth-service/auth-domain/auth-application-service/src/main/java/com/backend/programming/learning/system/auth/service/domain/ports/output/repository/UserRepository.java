package com.backend.programming.learning.system.auth.service.domain.ports.output.repository;

import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UserId userId);
    Optional<User> findByIdAndIsDeletedTrue(UserId userId);
    Optional<User> findByEmail(String email);
    Page<User> findAll(Integer page, Integer size);
    Page<User> findAllUsersByOrganization(UUID organizationId, Integer page, Integer size);
}
