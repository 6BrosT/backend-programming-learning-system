package com.backend.programming.learning.system.dto.method.create.submission_assignment;

import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
import com.backend.programming.learning.system.valueobject.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateSubmissionAssignmentCommand {
    @NotNull
    private final UUID userId;

    @NotNull
    private final UUID assignmentId;

    @NotNull
    private final Integer pass_status;

    @NotNull
    private final Float grade;

    @NotNull
    private final String content;

    @NotNull
    private final ZonedDateTime timeSubmit;

}