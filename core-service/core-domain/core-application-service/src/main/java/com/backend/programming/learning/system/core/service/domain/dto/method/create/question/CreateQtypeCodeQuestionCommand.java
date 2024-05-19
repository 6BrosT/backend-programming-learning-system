package com.backend.programming.learning.system.core.service.domain.dto.method.create.question;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class CreateQtypeCodeQuestionCommand extends CreateQuestionCommand {
    @NotNull
    private final String dslTemplate;

    private final String problemStatement;

    @NotNull
    private final Float maxGrade;

    @NotNull
    private final String codeQuestionName;


    public CreateQtypeCodeQuestionCommand(
            @NotNull(message = "Organization ID is required") UUID organizationId,
            @NotNull(message = "Created by is required") UUID createdBy,
            @NotNull(message = "Updated by is required") UUID updatedBy,
            @NotNull(message = "Difficulty by is required") String difficulty,
            @NotNull(message = "Name is required") String name,
            @NotNull(message = "Question text is required") String questionText,
            String generalFeedback,
            @NotNull(message = "Default mark is required")
            @DecimalMin(value = "0.0", message = "Default mark must be greater than or equal 0")
            @Digits(integer = 5, fraction = 2, message = "Default mark must have up to 5 digits and 2 decimals")
            BigDecimal defaultMark,
            @NotNull(message = "Question type is required") String qType,
            List<AnswerOfQuestion> answers, String dslTemplate,
            String problemStatement,
            Float maxGrade, String codeQuestionName) {
        super(organizationId,
                createdBy,
                updatedBy,
                difficulty,
                name,
                questionText,
                generalFeedback,
                defaultMark,
                qType,
                answers);
        this.dslTemplate = dslTemplate;
        this.problemStatement = problemStatement;
        this.maxGrade = maxGrade;
        this.codeQuestionName = codeQuestionName;
    }
}
