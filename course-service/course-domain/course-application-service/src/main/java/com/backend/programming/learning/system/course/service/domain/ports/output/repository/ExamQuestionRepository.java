package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.ExamQuestion;

import java.util.List;
import java.util.UUID;

public interface ExamQuestionRepository {
    ExamQuestion saveExamQuestion(ExamQuestion examQuestion);

    void assignExamToQuestions(List<ExamQuestion> examQuestions);

    void deleteByExamIdAndQuestionIdIn(UUID examId, List<UUID> questionIds);

    void deleteByExamId(UUID value);
}
