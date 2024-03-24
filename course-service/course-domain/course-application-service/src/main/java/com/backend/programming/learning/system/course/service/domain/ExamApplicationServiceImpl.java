package com.backend.programming.learning.system.course.service.domain;

import com.backend.programming.learning.system.course.service.domain.dto.create.CreateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.create.CreateExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.get.ExamsResponse;
import com.backend.programming.learning.system.course.service.domain.event.ExamCreateEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.ExamDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.ExamApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain
 * Create by Dang Ngoc Tien
 * Date 3/21/2024 - 10:17 PM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class ExamApplicationServiceImpl implements ExamApplicationService {
    private final ExamCreateCommandHandler examCreateCommandHandler;
    private final ExamDataMapper examDataMapper;

    @Override
    public CreateExamResponse createExam(CreateExamCommand createExamCommand) {
        ExamCreateEvent examCreateEvent = examCreateCommandHandler.createExam(createExamCommand);
        return examDataMapper.examCreateEventToCreateExamResponse(examCreateEvent, "Exam created successfully");
    }

    @Override
    public ExamsResponse findAll(String search) {
        return examCreateCommandHandler.findAll(search);
    }

    @Override
    public void deleteExam(Long examId) {
        examCreateCommandHandler.deleteExam(examId);
    }

    @Override
    public CreateExamResponse updateExam(Long examId, CreateExamCommand createExamCommand) {
        ExamCreateEvent examCreateEvent = examCreateCommandHandler.updateExam(examId, createExamCommand);
        return examDataMapper.examCreateEventToCreateExamResponse(examCreateEvent, "Exam updated successfully");
    }
}
