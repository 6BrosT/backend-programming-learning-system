package com.backend.programming.learning.system.auth.service.domain.event.user;

import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class UserUpdatedEvent extends UserEvent {
    public UserUpdatedEvent(User user, ZonedDateTime createdAt) {
        super(user, createdAt);
    }

    @Override
    public void fire() {
        
    }
}
