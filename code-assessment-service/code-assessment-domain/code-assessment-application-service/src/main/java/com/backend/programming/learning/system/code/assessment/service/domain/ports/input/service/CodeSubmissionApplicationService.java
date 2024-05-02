package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_submission.UpdateCodeSubmissionTestCaseCommand;

import javax.validation.Valid;

public interface CodeSubmissionApplicationService {
    CreateCodeSubmissionResponse createCodeSubmission(@Valid CreateCodeSubmissionCommand createCodeSubmissionCommand);

    void handleTestCaseResult(@Valid UpdateCodeSubmissionTestCaseCommand command);
}
