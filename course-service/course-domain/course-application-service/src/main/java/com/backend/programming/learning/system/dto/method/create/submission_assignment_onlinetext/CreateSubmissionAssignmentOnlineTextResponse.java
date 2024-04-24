package com.backend.programming.learning.system.dto.method.create.submission_assignment_onlinetext;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateSubmissionAssignmentOnlineTextResponse {
    private final UUID submissionAssignmentOnlineTextId;
    private final String message;
}
