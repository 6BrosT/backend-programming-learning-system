package com.backend.programming.learning.system.core.service.domain.event;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;

import java.time.ZonedDateTime;

public class CertificateCourseCreatedEvent extends CertificateCourseEvent {

    public CertificateCourseCreatedEvent(CertificateCourse certificateCourse, ZonedDateTime createdAt) {
        super(certificateCourse, createdAt);
    }

    @Override
    public void fire() {

    }
}