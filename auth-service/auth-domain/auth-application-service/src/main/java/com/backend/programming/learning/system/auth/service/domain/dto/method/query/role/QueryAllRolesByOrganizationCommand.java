package com.backend.programming.learning.system.auth.service.domain.dto.method.query.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllRolesByOrganizationCommand {
    @NotNull
    private final int pageNo;

    @NotNull
    private final int pageSize;
}
