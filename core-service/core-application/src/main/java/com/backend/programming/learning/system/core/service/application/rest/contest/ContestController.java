package com.backend.programming.learning.system.core.service.application.rest.contest;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest_user.CreateContestUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest_user.CreateContestUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest.ContestApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest_user.ContestUserApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.review.ReviewApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/core/contests", produces = "application/vnd.api.v1+json")
public class ContestController {
    private final ContestApplicationService contestApplicationService;
    private final ContestUserApplicationService contestUserApplicationService;

    public ContestController(ContestApplicationService contestApplicationService,
                             ContestUserApplicationService contestUserApplicationService) {
        this.contestApplicationService = contestApplicationService;
        this.contestUserApplicationService = contestUserApplicationService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateContestResponse> createCertificateCourse(
            @RequestBody CreateContestCommand createContestCommand) {
        log.info("Creating contest: {}", createContestCommand);
        CreateContestResponse createContestResponse =
                contestApplicationService.createContest(createContestCommand);
        log.info("Contest created: {}", createContestResponse);

        return ResponseEntity.ok(createContestResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<CreateContestUserResponse> registerContest(
            @RequestBody CreateContestUserCommand createContestUserCommand) {
        log.info("Creating Contest User course: {}", contestUserApplicationService);
        CreateContestUserResponse createContestUserResponse =
                contestUserApplicationService.createContestUser(createContestUserCommand);
        log.info("Contest User created: {}", createContestUserCommand);

        return ResponseEntity.ok(createContestUserResponse);
    }

}