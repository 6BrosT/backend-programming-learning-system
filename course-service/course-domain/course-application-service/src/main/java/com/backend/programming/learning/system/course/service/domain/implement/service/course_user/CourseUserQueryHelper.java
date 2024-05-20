package com.backend.programming.learning.system.course.service.domain.implement.service.course_user;

import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CourseUserQueryHelper {
    private final CourseUserRepository courseUserRepository;

    public CourseUserQueryHelper(CourseUserRepository courseUserRepository) {
        this.courseUserRepository = courseUserRepository;
    }

    public List<CourseUser> findByCourseId(UUID courseUserId) {
        List<CourseUser> courseUser = courseUserRepository.findByCourseId(courseUserId);
        log.info("Course user found successfully");
        return courseUser;
    }

    public List<CourseUser> findByCourseIdAndRoleTeacher(UUID courseId) {
        List<CourseUser> courseUser = courseUserRepository.findByCourseIdAndRoleTeacher(courseId);
        log.info("Course user found successfully");
        return courseUser;
    }

    public Page<CourseUser> findAllUserByCourseId(UUID id, String search, int pageNo, int pageSize) {
        Page<CourseUser> courseUser = courseUserRepository.findAllUserByCourseId(id, search, pageNo, pageSize);
        log.info("Course user found successfully");
        return courseUser;
    }

}
