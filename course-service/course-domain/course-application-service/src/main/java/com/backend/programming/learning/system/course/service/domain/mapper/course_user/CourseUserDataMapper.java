package com.backend.programming.learning.system.course.service.domain.mapper.course_user;

import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.backend.programming.learning.system.mapper.course_user
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 10:24 AM
 * Description: ...
 */
@Component
public class CourseUserDataMapper {
    public List<CourseUser> createCourseUserCommandToCourseUser(Course course, List<User> users) {
        return users.stream()
                .map(user -> CourseUser.builder()
                        .course(course)
                        .user(user)
                        .build())
                .toList();
    }
}