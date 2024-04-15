package com.backend.programming.learning.system.code.assessment.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CreateCodeQuestionCommand {
    @NotNull
    private final UUID questionId;
    private final List<TestCase> testCases;

    @NotNull
    private final String dslTemplate;
    @NotNull
    private final String problemStatement;
    @NotNull
    private final String inputFormat;
    @NotNull
    private final String outputFormat;
    @NotNull
    private final Boolean isDeleted;
}
