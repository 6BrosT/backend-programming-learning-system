package com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCertificateCourseUserCommand {
    @NotNull(message = "CertificateCourseId is required")
    private final UUID certificateCourseId;
    @NotNull(message = "UserId is required")
    private final UUID userId;
}
