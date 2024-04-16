package com.backend.programming.learning.system.dto.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.query
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 1:06 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryExamCommand {
    @NotNull
    private final UUID examId;
}
