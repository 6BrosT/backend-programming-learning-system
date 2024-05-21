package com.backend.programming.learning.system.course.service.domain.mapper.moodle;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.AssignmentModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.coure_type.CourseTypeModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course.CourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.module.ModuleModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.quiz.QuizModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.section.SectionModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment.Submission;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment.SubmissionPlugin;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user.UserModel;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseTypeRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class MoodleDataMapper {
    private final CourseTypeRepository courseTypeRepository;

    public MoodleDataMapper(CourseTypeRepository courseTypeRepository) {
        this.courseTypeRepository = courseTypeRepository;
    }

    public Course createCourse(CourseModel courseModel,Organization organization) {
        Optional<CourseType> courseType = courseTypeRepository.findByMoodleId(Integer.valueOf(courseModel.getCategoryid()));
        return Course.builder()
                .id(new CourseId(UUID.randomUUID()))
                .courseIdMoodle(Integer.valueOf(courseModel.getId()))
                .organization(organization)
                .name(courseModel.getFullname())
                .courseType(courseType.get())
                .key(courseModel.getIdnumber())
                .visible(courseModel.getVisible()==1)
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();
    }


    public CourseUser createCourseUser(Course course, User user,RoleMoodle roleMoodle) {
        return CourseUser.builder()
                .id(new CourseUserId(UUID.randomUUID()))
                .course(course)
                .user(user)
                .roleMoodle(roleMoodle)
                .build();
    }

    public Assignment createAssignment(Course course, AssignmentModel assignmentModel) {
        List<String> types= Arrays.asList("file","onlinetext");
        AtomicReference<Type> type= new AtomicReference<>(Type.FILE);
        AtomicReference<Boolean> fileType= new AtomicReference<>(false);
        AtomicReference<Boolean> onlineTextType= new AtomicReference<>(false);
        assignmentModel.getConfigs().forEach(config->{
            if(config.getPlugin().equals("file")){
                type.set(Type.FILE);
                fileType.set(true);
            }
            else if(config.getPlugin().equals("onlinetext")){
                type.set(Type.TEXT_ONLINE);
                onlineTextType.set(true);
            }

            if(fileType.get() && onlineTextType.get()){
                type.set(Type.BOTH);
            }
        });
        return Assignment.builder()
                .id(new AssignmentId(UUID.randomUUID()))
                .assignmentIdMoodle(Integer.valueOf(assignmentModel.getId()))
                .title(assignmentModel.getName())
                .courseId(course.getId())
                .intro(assignmentModel.getIntro())
                .maxScores(assignmentModel.getGrade().floatValue())
                .scores((float)0)
                .type(type.get())
                .time_open(Instant.ofEpochSecond(assignmentModel.getAllowsubmissionsfromdate()).atZone(ZoneId.of("UTC")))
                .time_close(Instant.ofEpochSecond(assignmentModel.getDuedate()).atZone(ZoneId.of("UTC")))
                .time_limit(Instant.ofEpochSecond(assignmentModel.getTimelimit()).atZone(ZoneId.of("UTC")))
                .visible(false)
                .build();
    }

    public SubmissionAssignment createSubmissionAssignment(Assignment assignment,User user, Submission submission) {
        return SubmissionAssignment.builder()
                .id(new SubmissionAssignmentId(UUID.randomUUID()))
                .assignment(assignment)
                .user(user)
                .pass_status(1)
                .content("content")
                .grade((float)-1)
                .submittedAt(Instant.ofEpochSecond(submission.getTimecreated()).atZone(ZoneId.of("UTC")))
                .build();
    }

    public SubmissionAssignmentFile createSubmissionAssignmentFile(SubmissionAssignment submissionAssignment, SubmissionPlugin plugin) {
        return SubmissionAssignmentFile.builder()
                .id(new AssignmentSubmissionFileId(UUID.randomUUID()))
                .assignmentSubmission(submissionAssignment)
                .num_file(plugin.getFileareas().get(0).getFiles().size())
                .build();
    }
    public CourseResponseEntity courseToCourseResponseEntity(Course course) {
        return CourseResponseEntity.builder()
                .id(course.getId().getValue())
                .name(course.getName())
                .visible(course.getVisible())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .build();
    }

    public SubmissionAssignmentOnlineText createSubmissionAssignmentOnlineText(SubmissionAssignment submissionCreate, SubmissionPlugin submissionPlugin) {
        return SubmissionAssignmentOnlineText.builder()
                .id(new SubmissionAssignmentOnlineTextId(UUID.randomUUID()))
                .content(submissionPlugin.getEditorfields().get(0).getText())
                .assignmentSubmission(submissionCreate)
                .build();
    }

    public Section createSection(Course course, SectionModel sectionModel) {
        return Section.builder()
                .id(new SectionId(UUID.randomUUID()))
                .sectionMoodleId(Integer.valueOf(sectionModel.getId()))
                .name(sectionModel.getName())
                .visible(sectionModel.getVisible())
                .courseId(course.getId())
                .build();
    }

    public Module createModule(Section section, ModuleModel module) {
        ZonedDateTime timeOpen=null;
        ZonedDateTime timeClose=null;
        if(module.getDates().size()!=0)
        {
            timeOpen=Instant.ofEpochSecond(module.getDates().get(0).getTimestamp()).atZone(ZoneId.of("UTC"));
            timeClose=Instant.ofEpochSecond(module.getDates().get(1).getTimestamp()).atZone(ZoneId.of("UTC"));
        }
        String content=null;
        if (module.getContents() != null && !module.getContents().isEmpty()) { // Sửa lỗi ở đây
            content = module.getContents().get(0).getFileurl();
            content=content.replace("/webservice","");
        }

        return Module.builder()
                .id(new ModuleId(UUID.randomUUID()))
                .cmid(Integer.valueOf(module.getId()))
                .section(section)
                .name(module.getName())
                .visible(module.getVisible())
                .typeModule(TypeModule.fromLabel(module.getModplural()))
                .content(content)
                .timeOpen(timeOpen)
                .timeClose(timeClose)
                .build();

    }

    public UpdateUserCommand updateUser(UserModel userModel, User user) {
        return UpdateUserCommand.builder()
                .userId(user.getId().getValue())
                .username(userModel.getUsername())
                .userIdMoodle(Integer.valueOf(userModel.getId()))
                .dob(user.getDob())
                .firstName(userModel.getFirstname())
                .lastName(userModel.getLastname())
                .phone(userModel.getPhone1())
                .address(userModel.getAddress())
                .avatarUrl(userModel.getProfileimageurl())
                .build();
    }

    public CreateUserCommand createUser(UserModel userModel) {
        return CreateUserCommand.builder()
                .email(userModel.getEmail())
                .username(userModel.getUsername())
                .userIdMoodle(Integer.valueOf(userModel.getId()))
                .password("")
                .firstName(userModel.getFirstname())
                .lastName(userModel.getLastname())
                .phone(userModel.getPhone1())
                .build();
    }

    public Course updateCourseByCourseMoodle(CourseModel courseModel, Course course) {
        return Course.builder()
                .id(course.getId())
                .name(courseModel.getFullname())
                .organization(course.getOrganization())
//                .courseType("MOODLE")
                .visible(courseModel.getVisible().equals("1"))
                .createdBy(course.getCreatedBy())
                .posts(course.getPosts())
                .exams(course.getExams())
                .assignments(course.getAssignments())
                .updatedBy(course.getUpdatedBy())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .build();
    }

    public Course createCourseByCourseMoodle(CourseModel courseModel, User user) {
        return Course.builder()
                .id(new CourseId(UUID.randomUUID()))
                .name(courseModel.getFullname())
//                .courseType("MOODLE")
                .organization(user.getOrganization())

                .visible(courseModel.getVisible().equals("1"))
                .createdBy(user)
                .updatedBy(user)
                .build();
    }

    public Exam updateExam(QuizModel quizModel, Exam exam, Course course) {
        return Exam.builder()
                .id(exam.getId())
                .course(course)
                .name(quizModel.getName())
                .score(quizModel.getGrade().floatValue())
                .maxScore(quizModel.getGrade().floatValue())
                .timeOpen(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(quizModel.getTimeopen()),
                        ZoneId.of("UTC")))
                .timeClose(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(quizModel.getTimeclose()),
                        ZoneId.of("UTC")))
                .timeLimit(quizModel.getTimelimit().intValue())
                .intro(quizModel.getIntro())
                .overdueHandling(OverdueHandling.AUTOSUBMIT)
                .canRedoQuestions(quizModel.getCanredoquestions().equals("0") ? false : true)
                .maxAttempts(quizModel.getAttemptonlast())
                .shuffleAnswers(quizModel.getShuffleanswers().equals("0") ? false : true)
                .gradeMethod("QUIZ_GRADEHIGHEST")
                .createdAt(exam.getCreatedAt())
                .updatedAt(exam.getUpdatedAt())
                .build();
    }

    public Exam createExam(QuizModel quizModel, Course course) {
        return Exam.builder()
                .id(new ExamId(UUID.randomUUID()))
                .course(course)
                .name(quizModel.getName())
                .score(quizModel.getGrade().floatValue())
                .maxScore(quizModel.getGrade().floatValue())
                .timeOpen(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(quizModel.getTimeopen()),
                        ZoneId.of("UTC")))
                .timeClose(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(quizModel.getTimeclose()),
                        ZoneId.of("UTC")))
                .timeLimit(quizModel.getTimelimit().intValue())
                .intro(quizModel.getIntro())
                .overdueHandling(OverdueHandling.AUTOSUBMIT)
                .canRedoQuestions(quizModel.getCanredoquestions().equals("0") ? false : true)
                .maxAttempts(quizModel.getAttemptonlast())
                .shuffleAnswers(quizModel.getShuffleanswers().equals("0") ? false : true)
                .gradeMethod("QUIZ_GRADEHIGHEST")
                .build();
    }

    public CourseType createCourseType(CourseTypeModel courseTypeModel) {
        Integer moodleId = Integer.valueOf(courseTypeModel.getId());
        return CourseType.builder()
                .id(new CourseTypeId(UUID.randomUUID()))
                .name(courseTypeModel.getName())
                .moodleId(moodleId)
                .build();
    }
}
