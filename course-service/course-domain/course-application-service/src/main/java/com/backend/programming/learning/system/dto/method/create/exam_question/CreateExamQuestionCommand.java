package com.backend.programming.learning.system.dto.method.create.exam_question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.exam_question
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 2:00 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class CreateExamQuestionCommand {
    @NotNull(message = "Exam id is required")
    private UUID examId;
    @NotNull(message = "Question ids are required")
    private List<UUID> questionIds;
}
