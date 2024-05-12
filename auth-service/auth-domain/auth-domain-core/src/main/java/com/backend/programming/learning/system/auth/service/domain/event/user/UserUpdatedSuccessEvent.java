package com.backend.programming.learning.system.auth.service.domain.event.user;

import com.backend.programming.learning.system.auth.service.domain.entity.User;

import java.time.ZonedDateTime;

public class UserUpdatedSuccessEvent extends UserEvent {
    public UserUpdatedSuccessEvent(User user, ZonedDateTime createdAt) {
        super(user, createdAt);
    }

    @Override
    public void fire() {

    }
}
