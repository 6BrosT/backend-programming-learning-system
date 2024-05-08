package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class GetSharedSolutionDetailCommand {
    @NotNull(message = "sharedSolutionId must not be null")
    UUID sharedSolutionId;
}
