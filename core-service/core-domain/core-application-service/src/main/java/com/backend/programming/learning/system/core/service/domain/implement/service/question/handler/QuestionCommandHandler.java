package com.backend.programming.learning.system.core.service.domain.implement.service.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.QuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionDeletedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.delete.QuestionDeleteHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query.QuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.question.QuestionDeletedMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class QuestionCommandHandler {
    private final QuestionQueryHelper questionQueryHelper;
    private final QuestionDeleteHelper questionDeleteHelper;
    private final QuestionDeletedMessagePublisher questionDeletedMessagePublisher;

    public QuestionCommandHandler(QuestionQueryHelper questionQueryHelper, QuestionDeleteHelper questionDeleteHelper,
                                  QuestionDeletedMessagePublisher questionDeletedMessagePublisher) {
        this.questionQueryHelper = questionQueryHelper;
        this.questionDeleteHelper = questionDeleteHelper;
        this.questionDeletedMessagePublisher = questionDeletedMessagePublisher;
    }

    public QuestionResponseEntity queryQuestionById(UUID questionId) {
        return questionQueryHelper
                .queryQuestionById(questionId);
    }

    public List<QuestionResponseEntity> queryAllQuestion() {
        return questionQueryHelper
                .queryAllQuestion();
    }

    public QuestionDeleteResponse deleteQuestionById(UUID questionId) {
        QuestionDeletedEvent questionDeletedEvent = questionDeleteHelper.deleteQuestionById(questionId);

        questionDeletedMessagePublisher.publish(questionDeletedEvent);

        return QuestionDeleteResponse.builder()
                .questionId(questionId)
                .qtypeId(questionDeletedEvent.getQtypeID())
                .message("Question deleted successfully")
                .build();
    }
}