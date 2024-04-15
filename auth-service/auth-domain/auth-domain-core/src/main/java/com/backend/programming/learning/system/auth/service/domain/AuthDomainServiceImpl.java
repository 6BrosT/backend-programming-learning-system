package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.event.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.UserDeletedEvent;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class AuthDomainServiceImpl implements AuthDomainService {
    @Override
    public UserCreatedEvent createUser(User user, DomainEventPublisher<UserCreatedEvent>
            userCreatedEventDomainEventPublisher) {
        user.initializeUser();
        log.info("User with id: {} is initiated", user.getId().getValue());
        return new UserCreatedEvent(user, ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)), userCreatedEventDomainEventPublisher);
    }

    @Override
    public UserDeletedEvent deleteUser(User user, DomainEventPublisher<UserDeletedEvent>
            userDeletedEventDomainEventPublisher) {
        user.deleteUser();
        log.info("User with id: {} is deleted", user.getId().getValue());
        return new UserDeletedEvent(user, ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)), userDeletedEventDomainEventPublisher);
    }

    @Override
    public void createOrganization(Organization organization) {
        organization.initializeOrganization();
        log.info("Organization with id: {} is initiated", organization.getId().getValue());
    }

    @Override
    public void deleteOrganization(Organization organization) {
        organization.deleteOrganization();
        log.info("Organization with id: {} is deleted", organization.getId().getValue());
    }

    @Override
    public void createUserRole(UserRole userRole) {
        userRole.initializeUserRole();
        log.info("User role with id: {} is initiated", userRole.getId().getValue());
    }

    @Override
    public void createRole(Role role) {
        role.initializeRole();
        log.info("Role with id: {} is initiated", role.getId().getValue());
    }
}