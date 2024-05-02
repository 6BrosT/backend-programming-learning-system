package com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_submission.UpdateCodeSubmissionTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmissionTestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class CodeSubmissionDataMapper {
    public CreateCodeSubmissionResponse codeSubmissionToCreateCodeSubmissionResponse(CodeSubmission codeSubmission) {
        return CreateCodeSubmissionResponse.builder()
                .message("Submit successfully")
                .status(codeSubmission.getGradingStatus().name())
                .codeSubmissionId(codeSubmission.getId().getValue())
                .build();
    }

    public CodeSubmission createCodeSubmissionCommandToCodeSubmission(CreateCodeSubmissionCommand createCodeSubmissionCommand) {
        return CodeSubmission.builder()
                .codeQuestionId(new CodeQuestionId(createCodeSubmissionCommand.getCodeQuestionId()))
                .languageId(new ProgrammingLanguageId(createCodeSubmissionCommand.getLanguageId()))
                .userId(new UserId(createCodeSubmissionCommand.getUserId()))
                .sourceCode(createCodeSubmissionCommand.getSourceCode())
                .build();
    }

    public CodeSubmissionTestCase updateCodeSubmissionTestCaseCommandToCodeSubmissionTestCase(UpdateCodeSubmissionTestCaseCommand command) {
        return CodeSubmissionTestCase.builder()
                .judgeToken(command.getToken())
                .stderr(command.getStderr())
                .actualOutput(command.getStdout())
                .runTime(command.getTime())
                .memory(command.getMemory())
                .compileOutput(command.getCompile_output())
                .message(command.getMessage())
                .statusDescription(command.getStatus().getDescription())
                .build();
    }
}
