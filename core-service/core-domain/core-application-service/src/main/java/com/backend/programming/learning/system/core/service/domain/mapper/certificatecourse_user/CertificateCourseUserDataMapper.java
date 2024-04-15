package com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse_user;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CertificateCourseUserDataMapper {
    public CertificateCourseUser createCertificateCourseUserCommandToCertificateCourseUser(
            CreateCertificateCourseUserCommand createCertificateCourseUserCommand) {
        return CertificateCourseUser.builder()
                .certificateCourse(CertificateCourse.builder()
                        .id(new CertificateCourseId(createCertificateCourseUserCommand.getCertificateCourseId()))
                        .build())
                .user(User.builder()
                        .id(new UserId(createCertificateCourseUserCommand.getUserId()))
                        .build())
                .isCompleted(false)
                .build();
    }

    public CreateCertificateCourseUserResponse certificateCourseUserToCreateCertificateCourseUserResponse(
            CertificateCourseUser certificateCourseUser, String message) {
        return CreateCertificateCourseUserResponse.builder()
                .certificateCourseUserId(certificateCourseUser.getId())
                .message(message)
                .build();
    }
}