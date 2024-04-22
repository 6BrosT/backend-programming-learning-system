package com.backend.programming.learning.system;

import com.backend.programming.learning.system.entity.*;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CourseDomainServiceImpl implements CourseDomainService{
    @Override
    public void createExam(Exam exam) {
        exam.initializeExam();
        log.info("Exam with id: {} is initiated", exam.getId().getValue());
    }

    @Override
    public void createCourse(Course course) {
        course.initializeCourse();
        log.info("Course with id: {} is initiated", course.getId().getValue());
    }

    @Override
    public void createQuestion(Question question) {
        question.initializeQuestion();
        log.info("Question with id: {} is initiated", question.getId().getValue());
    }

    @Override
    public void createAssignment(Assignment assignment) {
        assignment.initializeAssignment();
        log.info("Assignment with id: {} is initiated", assignment.getId().getValue());

    }

    @Override
    public void createPost(Post post) {
        post.initializePost();
        log.info("Post with id: {} is initiated", post.getId().getValue());
    }

    @Override
    public void createSubmissionAssignment(SubmissionAssignment submissionAssignment) {
        submissionAssignment.initializeAssignmentSubmission();
        log.info("AssignmentSubmission with id: {} is initiated", submissionAssignment.getId().getValue());
    }

    @Override
    public void createSubmissionAssignmentOnlineText(SubmissionAssignmentOnlineText submissionAssignmentOnlineText) {
        submissionAssignmentOnlineText.initializeSubmissionAssignmentOnlineText();
        log.info("SubmissionAssignmentOnlineText with id: {} is initiated", submissionAssignmentOnlineText.getId().getValue());
    }

    @Override
    public void createSubmissionAssignmentFile(SubmissionAssignmentFile submissionAssignmentFile) {
        submissionAssignmentFile.initializeSubmissionAssignmentFile();
        log.info("SubmissionAssignmentFile with id: {} is initiated", submissionAssignmentFile.getId().getValue());

    }

    @Override
    public void createCourseUsers(List<CourseUser> courseUsers) {
        courseUsers.forEach(CourseUser::initializeCourseUser);
        log.info("CourseUser is initiated");
    }

    @Override
    public void createExamQuestions(List<ExamQuestion> examQuestions) {
        examQuestions.forEach(ExamQuestion::initializeExamQuestion);
        log.info("ExamQuestion is initiated");
    }

    @Override
    public void createOrganization(Organization organization) {
        organization.initializeOrganization();
        log.info("Organization with id: {} is initiated", organization.getId().getValue());
    }

    @Override
    public void createQuestionBankCategory(QuestionBankCategory questionBankCategory) {
        questionBankCategory.initializeQuestionBankCategory();
        log.info("QuestionBankCategory with id: {} is initiated", questionBankCategory.getId().getValue());
    }
}
