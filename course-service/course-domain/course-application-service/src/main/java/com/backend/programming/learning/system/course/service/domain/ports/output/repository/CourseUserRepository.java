package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseUserRepository {
    CourseUser saveCourseUser(CourseUser courseUser);

    void saveAll(List<CourseUser> courseUsers);

    List<CourseUser> findByCourseId(UUID courseUserId);

    void deleteByCourseIdAndUserIdIn(UUID courseId, List<UUID> userIds);
    void deleteByCourseIdAndUserId(UUID courseId, UUID userIds);

    List<CourseUser> findByCourseIdAndRoleTeacher(UUID courseId);
}
