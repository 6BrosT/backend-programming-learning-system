package com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class ChapterDataAccessMapper {

    private final CertificateCourseJpaRepository certificateCourseJpaRepository;
    private final UserJpaRepository userJpaRepository;

    public ChapterDataAccessMapper(CertificateCourseJpaRepository certificateCourseJpaRepository,
                                   UserJpaRepository userJpaRepository) {
        this.certificateCourseJpaRepository = certificateCourseJpaRepository;
        this.userJpaRepository = userJpaRepository;
    }

    public ChapterEntity chapterToChapterEntity(Chapter chapter) {
        CertificateCourseEntity certificateCourse = certificateCourseJpaRepository
                .findById(chapter.getCertificateCourseId().getValue())
                .orElseThrow(() -> new CertificateCourseNotFoundException("Certificate course with id: " +
                        chapter.getCertificateCourseId().getValue() + " could not be found!")
                );
        UserEntity createdBy = userJpaRepository
                .findById(chapter.getCreatedBy().getValue())
                .orElseThrow(() -> new UserNotFoundException("User with id: " +
                        chapter.getCreatedBy().getValue() + " could not be found!")
                );
        UserEntity updatedBy = userJpaRepository
                .findById(chapter.getUpdatedBy().getValue())
                .orElseThrow(() -> new UserNotFoundException("User with id: " +
                        chapter.getUpdatedBy().getValue() + " could not be found!")
                );

        return ChapterEntity.builder()
                .id(chapter.getId().getValue())
                .certificateCourse(certificateCourse)
                .title(chapter.getTitle())
                .description(chapter.getDescription())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(chapter.getCreatedAt())
                .updatedAt(chapter.getUpdatedAt())
                .build();
    }

    public Chapter chapterEntityToChapter(ChapterEntity chapterEntity) {
        return Chapter.builder()
                .id(new ChapterId(chapterEntity.getId()))
                .certificateCourseId(new CertificateCourseId(chapterEntity.getCertificateCourse().getId()))
                .title(chapterEntity.getTitle())
                .description(chapterEntity.getDescription())
                .createdBy(new UserId(chapterEntity.getCreatedBy().getId()))
                .updatedBy(new UserId(chapterEntity.getUpdatedBy().getId()))
                .createdAt(chapterEntity.getCreatedAt())
                .updatedAt(chapterEntity.getUpdatedAt())
                .build();
    }
}
