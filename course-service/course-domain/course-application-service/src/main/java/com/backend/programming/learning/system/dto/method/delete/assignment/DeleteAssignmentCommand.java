package com.backend.programming.learning.system.dto.method.delete.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteAssignmentCommand {
    @NotNull
    private final UUID assignmentId;

}
