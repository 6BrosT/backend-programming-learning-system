package com.backend.programming.learning.system.auth.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserRoleResponse {
    @NotNull
    private String name;

    @NotNull
    private ZonedDateTime createdAt;

    @NotNull
    private final String message;
}
