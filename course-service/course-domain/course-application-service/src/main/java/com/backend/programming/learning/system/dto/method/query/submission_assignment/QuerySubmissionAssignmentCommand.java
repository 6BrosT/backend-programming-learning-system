package com.backend.programming.learning.system.dto.method.query.submission_assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QuerySubmissionAssignmentCommand {
    @NotNull
    private final UUID submissionId;
}