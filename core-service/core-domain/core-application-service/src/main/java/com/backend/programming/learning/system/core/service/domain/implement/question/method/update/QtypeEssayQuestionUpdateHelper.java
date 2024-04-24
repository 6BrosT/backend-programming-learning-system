package com.backend.programming.learning.system.core.service.domain.implement.question.method.update;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeEssayQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeEssayQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeEssayQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class QtypeEssayQuestionUpdateHelper {
    // Repositories
    private final QtypeEssayQuestionRepository qtypeEssayQuestionRepository;

    // Mappers
    private final QtypeEssayQuestionDataMapper qtypeEssayQuestionDataMapper;

    private final CommonUpdateHelper commonUpdateHelper;
    private final CoreDomainService coreDomainService;

    public QtypeEssayQuestionUpdateHelper(
            QtypeEssayQuestionRepository qtypeEssayQuestionRepository,
            QtypeEssayQuestionDataMapper qtypeEssayQuestionDataMapper,
            CommonUpdateHelper commonUpdateHelper,
            CoreDomainService coreDomainService) {
        this.commonUpdateHelper = commonUpdateHelper;
        this.qtypeEssayQuestionRepository = qtypeEssayQuestionRepository;
        this.qtypeEssayQuestionDataMapper = qtypeEssayQuestionDataMapper;
        this.coreDomainService = coreDomainService;
    }

    // Persist updated Qtype Essay Question entity in database
    public QuestionUpdatedEvent updateQtypeEssayQuestion(UpdateQtypeEssayQuestionCommand updateQtypeEssayQuestionCommand) {
        // check answers if exist when updating answers
        if (updateQtypeEssayQuestionCommand.getQuestion().getAnswers() != null)
            updateQtypeEssayQuestionCommand
                    .getQuestion()
                    .getAnswers()
                    .forEach(answer -> commonUpdateHelper.checkAnswerExist(answer.getAnswerId()));

        QtypeEssayQuestion qtypeEssayQuestion = getQtypeEssayQuestion(updateQtypeEssayQuestionCommand.getQtEssayQuestionId());
        QtypeEssayQuestion mappedQtypeEssayQuestion = qtypeEssayQuestionDataMapper
                .updateQtypeEssayQuestionCommandToQtypeEssayQuestion(updateQtypeEssayQuestionCommand, qtypeEssayQuestion);

        updateQtypeEssayQuestionInDb(mappedQtypeEssayQuestion);
        log.info("Qtype Essay Question updated with id: {}", mappedQtypeEssayQuestion.getId().getValue());

        commonUpdateHelper.updateQuestion(mappedQtypeEssayQuestion.getQuestion());
        log.info("Question updated with id: {}", mappedQtypeEssayQuestion.getQuestion().getId().getValue());

        return coreDomainService.updateQtypeEssayQuestion(mappedQtypeEssayQuestion.getQuestion(), mappedQtypeEssayQuestion);
    }

    // Check if Qtype Essay Question exist in database and get it
    private QtypeEssayQuestion getQtypeEssayQuestion(UUID qtypeEssayQuestionId) {
        Optional<QtypeEssayQuestion> qtypeEssayQuestion = qtypeEssayQuestionRepository.findQtypeEssayQuestion(qtypeEssayQuestionId);

        if (qtypeEssayQuestion.isEmpty()) {
            log.error("Qtype Essay Question not found with id: {}", qtypeEssayQuestionId);
            throw new QtypeEssayQuestionNotFoundException("Qtype Essay Question with id " + qtypeEssayQuestionId + " not found");
        }
        log.info("Qtype Essay Question found with id: {}", qtypeEssayQuestionId);
        return qtypeEssayQuestion.get();
    }

    // Update Qtype Essay Question entity in database
    private void updateQtypeEssayQuestionInDb(QtypeEssayQuestion qtypeEssayQuestion) {
        qtypeEssayQuestionRepository.updateQtypeEssayQuestion(qtypeEssayQuestion);
    }
}
