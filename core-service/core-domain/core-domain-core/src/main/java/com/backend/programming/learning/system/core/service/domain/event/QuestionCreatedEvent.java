package com.backend.programming.learning.system.core.service.domain.event;

import com.backend.programming.learning.system.core.service.domain.entity.Question;

import java.time.ZonedDateTime;

public class QuestionCreatedEvent extends QuestionEvent {
    public QuestionCreatedEvent(Question question, ZonedDateTime createdAt) {
        super(question, createdAt);
    }

    @Override
    public void fire() {

    }
}
