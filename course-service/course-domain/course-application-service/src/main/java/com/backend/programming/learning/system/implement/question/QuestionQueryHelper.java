package com.backend.programming.learning.system.implement.question;

import com.backend.programming.learning.system.dto.method.query.question.QueryAllQuestionCommand;
import com.backend.programming.learning.system.entity.Question;
import com.backend.programming.learning.system.ports.output.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.backend.programming.learning.system.implement.question
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 2:36 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionQueryHelper {
    private final QuestionRepository questionRepository;
    @Transactional(readOnly = true)
    public Page<Question> findAllQuestions(QueryAllQuestionCommand queryAllQuestionCommand) {
        return questionRepository.findAll(queryAllQuestionCommand.getPageNo(), queryAllQuestionCommand.getPageSize());
    }
}
