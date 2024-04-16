package com.backend.programming.learning.system.core.service.domain.dto.delete.contest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteContestCommand {
    @NotNull
    private final UUID contestId;
}
