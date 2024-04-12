package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.CoreApplicationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
class CoreApplicationServiceImpl implements CoreApplicationService {
    private final QuestionCreateCommandHandler questionCreateCommandHandler;
    private final CertificateCourseCreateCommandHandler certificateCourseCreateCommandHandler;

    public CoreApplicationServiceImpl(QuestionCreateCommandHandler questionCreateCommandHandler,
                                      CertificateCourseCreateCommandHandler certificateCourseCreateCommandHandler) {
        this.questionCreateCommandHandler = questionCreateCommandHandler;
        this.certificateCourseCreateCommandHandler = certificateCourseCreateCommandHandler;
    }

    @Override
    public CreateQuestionResponse createQuestion(@Valid CreateQuestionCommand createQuestionCommand) {
        return questionCreateCommandHandler.createQuestion(createQuestionCommand);
    }

    @Override
    public CreateCertificateCourseResponse createCertificateCourse(@Valid CreateCertificateCourseCommand createCertificateCourseCommand) {
        return certificateCourseCreateCommandHandler.createCertificateCourse(createCertificateCourseCommand);
    }
}