package com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_question;

import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateChapterQuestionResponse {
    @NotNull
    private final UUID chapterId;
    @NotNull
    private final UUID chapterQuestionId;
    @NotNull
    private final String message;
}