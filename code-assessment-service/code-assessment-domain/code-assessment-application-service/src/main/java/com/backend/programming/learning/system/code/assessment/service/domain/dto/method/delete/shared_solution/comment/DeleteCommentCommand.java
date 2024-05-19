package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class DeleteCommentCommand {
    @NotNull(message = "userId must not be null")
    UUID userId;

    @NotNull(message = "sharedSolutionId must not be null")
    @Setter
    UUID sharedSolutionId;

    @NotNull(message = "commentId must not be null")
    @Setter
    UUID commentId;

}