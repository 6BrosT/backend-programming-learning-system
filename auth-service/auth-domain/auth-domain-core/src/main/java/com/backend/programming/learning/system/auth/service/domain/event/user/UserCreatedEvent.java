package com.backend.programming.learning.system.auth.service.domain.event.user;

import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class UserCreatedEvent extends UserEvent {
    public UserCreatedEvent(User user, ZonedDateTime createdAt) {
        super(user, createdAt);
    }

    @Override
    public void fire() {
    }
}
