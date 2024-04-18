package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QtypeCodeQuestionRepository {
    QtypeCodeQuestion saveQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion);
    Optional<QtypeCodeQuestion> findQtypeCodeQuestion(UUID qtCodeQuestionId);
    List<QtypeCodeQuestion> findAllQtypeCodeQuestions();
    UUID getId(UUID questionId);
    void updateQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion);
}
