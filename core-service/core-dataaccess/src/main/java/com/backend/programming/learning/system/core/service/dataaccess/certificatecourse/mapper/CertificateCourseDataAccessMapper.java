package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.review.mapper.ReviewDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.mapper.TopicDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.topic.repository.TopicJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CertificateCourseDataAccessMapper {
    private final UserJpaRepository userJpaRepository;
    private final TopicJpaRepository topicJpaRepository;
    private final ReviewDataAccessMapper reviewDataAccessMapper;
    private final ChapterDataAccessMapper chapterDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;
    private final TopicDataAccessMapper topicDataAccessMapper;

    public CertificateCourseDataAccessMapper(UserJpaRepository userJpaRepository,
                                             TopicJpaRepository topicJpaRepository,
                                             ReviewDataAccessMapper reviewDataAccessMapper,
                                             ChapterDataAccessMapper chapterDataAccessMapper,
                                             UserDataAccessMapper userDataAccessMapper,
                                             TopicDataAccessMapper topicDataAccessMapper) {
        this.userJpaRepository = userJpaRepository;
        this.topicJpaRepository = topicJpaRepository;
        this.reviewDataAccessMapper = reviewDataAccessMapper;
        this.chapterDataAccessMapper = chapterDataAccessMapper;
        this.userDataAccessMapper = userDataAccessMapper;
        this.topicDataAccessMapper = topicDataAccessMapper;
    }

    public CertificateCourseEntity certificateCourseToCertificateCourseEntity(CertificateCourse certificateCourse) {
        UserEntity createdBy = userJpaRepository
                .findById(certificateCourse.getCreatedBy().getId().getValue())
                .orElseThrow(() -> new UserNotFoundException("User with id: " +
                        certificateCourse.getCreatedBy().getId().getValue() + " could not be found!")
                );
        UserEntity updatedBy = userJpaRepository
                .findById(certificateCourse.getUpdatedBy().getId().getValue())
                .orElseThrow(() -> new UserNotFoundException("User with id: " +
                        certificateCourse.getUpdatedBy().getId().getValue() + " could not be found!")
                );
        TopicEntity topic = topicJpaRepository
                .findById(certificateCourse.getTopic().getId().getValue())
                .orElseThrow(() -> new TopicNotFoundException("Topic with id: " +
                        certificateCourse.getTopic().getId().getValue() + " could not be found!")
                );

        return CertificateCourseEntity.builder()
                .id(certificateCourse.getId().getValue())
                .name(certificateCourse.getName())
                .description(certificateCourse.getDescription())
                .skillLevel(certificateCourse.getSkillLevel())
                .avgRating(certificateCourse.getAvgRating())
                .topic(topic)
                .certificateCourseUsers(new ArrayList<>())
                .reviews(new ArrayList<>())
                .chapters(new ArrayList<>())
                .startTime(certificateCourse.getStartTime())
                .endTime(certificateCourse.getEndTime())
                .isDeleted(certificateCourse.getDeleted())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(certificateCourse.getCreatedAt())
                .updatedAt(certificateCourse.getUpdatedAt())
                .build();
    }

    public CertificateCourse certificateCourseEntityToCertificateCourse(
            CertificateCourseEntity certificateCourseEntity) {
        User createdBy = userDataAccessMapper.userEntityToUser(certificateCourseEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUser(certificateCourseEntity.getUpdatedBy());
        Topic topic = topicDataAccessMapper.topicEntityToTopic(certificateCourseEntity.getTopic());

        return CertificateCourse.builder()
                .id(new CertificateCourseId(certificateCourseEntity.getId()))
                .name(certificateCourseEntity.getName())
                .description(certificateCourseEntity.getDescription())
                .skillLevel(certificateCourseEntity.getSkillLevel())
                .avgRating(certificateCourseEntity.getAvgRating())
                .topic(topic)
                .reviews(new ArrayList<>())
                .chapters(new ArrayList<>())
                .registeredUsers(new ArrayList<>())
                .startTime(certificateCourseEntity.getStartTime())
                .endTime(certificateCourseEntity.getEndTime())
                .isDeleted(certificateCourseEntity.getIsDeleted())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(certificateCourseEntity.getCreatedAt())
                .updatedAt(certificateCourseEntity.getUpdatedAt())
                .build();
    }

}
