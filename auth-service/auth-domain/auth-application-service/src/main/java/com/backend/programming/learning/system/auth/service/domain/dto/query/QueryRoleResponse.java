package com.backend.programming.learning.system.auth.service.domain.dto.query;

import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryRoleResponse {
    @NotNull
    private UUID id;

    private String description;
    private String name;

    @NotNull
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}