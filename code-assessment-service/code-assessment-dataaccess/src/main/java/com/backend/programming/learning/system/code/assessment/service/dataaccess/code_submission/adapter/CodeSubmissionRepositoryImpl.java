package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.mapper.CodeSubmissionDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.repository.CodeSubmissionJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionRepository;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class CodeSubmissionRepositoryImpl implements CodeSubmissionRepository {
    private final CodeSubmissionJpaRepository jpaRepository;
    private final CodeSubmissionDataAccessMapper dataAccessMapper;

    public CodeSubmissionRepositoryImpl(CodeSubmissionJpaRepository jpaRepository, CodeSubmissionDataAccessMapper dataAccessMapper) {
        this.jpaRepository = jpaRepository;
        this.dataAccessMapper = dataAccessMapper;
    }

    @Override
    public CodeSubmission save(CodeSubmission codeSubmission) {
        CodeSubmissionEntity entity = dataAccessMapper.codeSubmissionToEntity(codeSubmission);
        return dataAccessMapper.entityToCodeSubmission(jpaRepository.save(entity));
    }

    @Override
    public void updateOneTestCase(CodeSubmissionId id) {

        jpaRepository.increaseNumOfTestCaseGradedByOne(id.getValue());
    }

    @Override
    public Optional<CodeSubmission> findById(CodeSubmissionId id) {
        return jpaRepository.findById(id.getValue()).map(dataAccessMapper::entityToCodeSubmission);
    }
}
