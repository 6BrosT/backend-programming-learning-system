package com.backend.programming.learning.system.course.service.domain.event.question.event;

import com.backend.programming.learning.system.domain.event.DomainEvent;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.course.service.domain.entity.Question;

import java.time.ZonedDateTime;

public abstract class QuestionEvent implements DomainEvent<Question> {
    private final Question question;
    private final ZonedDateTime createdAt;
    private final CopyState copyState;

    public QuestionEvent(Question question, ZonedDateTime createdAt, CopyState copyState) {
        this.question = question;
        this.createdAt = createdAt;
        this.copyState = copyState;
    }

    public Question getQuestion() {
        return question;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public CopyState getCopyState() {
        return copyState;
    }
}
