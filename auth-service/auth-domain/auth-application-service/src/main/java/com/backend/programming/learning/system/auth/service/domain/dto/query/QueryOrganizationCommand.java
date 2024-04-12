package com.backend.programming.learning.system.auth.service.domain.dto.query;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryOrganizationCommand {
    @NotNull
    private final UUID organizationId;
}
