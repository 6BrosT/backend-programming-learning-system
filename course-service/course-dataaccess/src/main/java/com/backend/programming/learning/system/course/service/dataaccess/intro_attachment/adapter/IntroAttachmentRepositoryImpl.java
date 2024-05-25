package com.backend.programming.learning.system.course.service.dataaccess.intro_attachment.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.intro_attachment.mapper.IntroAttachmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.intro_attachment.repository.IntroAttachmentJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;
import com.backend.programming.learning.system.course.service.domain.entity.IntroFile;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.IntroAttachmentRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.IntroFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class IntroAttachmentRepositoryImpl implements IntroAttachmentRepository {

    private final IntroAttachmentJpaRepository introAttachmentJpaRepository;
    private final IntroAttachmentDataAccessMapper introAttachmentDataAccessMapper;


    @Override
    public Optional<IntroAttachment> findById(UUID introAttachmentId) {
        return introAttachmentJpaRepository.findById(introAttachmentId)
                .map(introAttachmentDataAccessMapper::introAttachmentEntityToIntroAttachment);
    }

    @Override
    public IntroAttachment save(IntroAttachment introAttachment) {
        return introAttachmentDataAccessMapper.introAttachmentEntityToIntroAttachment(introAttachmentJpaRepository
                .saveAndFlush(introAttachmentDataAccessMapper
                        .introAttachmentToIntroAttachmentEntity(introAttachment)));
    }

    @Override
    public void deleteById(UUID introAttachmentId) {

    }

    @Override
    public List<IntroAttachment> findAllByAssignmentId(UUID assignmentId) {
        return null;
    }
}
