package com.backend.programming.learning.system.auth.service.domain.dto.method.update.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateOrganizationCommand {
    @NotNull
    private final UUID organizationId;

    private String description;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String apiKey;

    private String moodleUrl;

    @NotNull
    private final UUID updatedBy;
}
