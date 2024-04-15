package com.backend.programming.learning.system.core.service.domain.ports.input.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQuestionResponse;

import java.util.List;
import java.util.UUID;

public interface QuestionApplicationService {
    QueryQuestionResponse queryQuestionById(UUID questionId);
    List<QueryQuestionResponse> queryAllQuestion();
}