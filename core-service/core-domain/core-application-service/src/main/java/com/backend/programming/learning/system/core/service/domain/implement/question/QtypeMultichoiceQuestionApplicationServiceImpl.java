package com.backend.programming.learning.system.core.service.domain.implement.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeMultichoiceQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.implement.question.handler.QtypeMultichoiceQuestionCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeMultichoiceQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@Validated
public class QtypeMultichoiceQuestionApplicationServiceImpl implements QtypeMultichoiceQuestionApplicationService {
    private final QtypeMultichoiceQuestionCommandHandler qtypeMultichoiceQuestionCommandHandler;

    public QtypeMultichoiceQuestionApplicationServiceImpl(QtypeMultichoiceQuestionCommandHandler qtypeMultichoiceQuestionCommandHandler) {
        this.qtypeMultichoiceQuestionCommandHandler = qtypeMultichoiceQuestionCommandHandler;
    }

    @Override
    public CreateQuestionResponse createQtypeMultichoiceQuestion(CreateQtypeMultichoiceQuestionCommand createQtypeMultichoiceQuestionCommand) {
        return qtypeMultichoiceQuestionCommandHandler
                .createQtypeMultichoiceQuestion(createQtypeMultichoiceQuestionCommand);
    }

    @Override
    public QueryQtypeMultichoiceQuestionResponse queryQtypeMultichoiceQuestionById(UUID qtMultichoiceQuestionId) {
        return qtypeMultichoiceQuestionCommandHandler.queryQtypeMultichoiceQuestionById(qtMultichoiceQuestionId);
    }

    @Override
    public List<QueryQtypeMultichoiceQuestionResponse> queryAllQtypeMultichoiceQuestion() {
        return qtypeMultichoiceQuestionCommandHandler.queryAllQtypeMultichoiceQuestion();
    }
}