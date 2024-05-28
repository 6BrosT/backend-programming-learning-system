package com.backend.programming.learning.system.core.service.dataaccess.contest.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.projection.ContestProjection;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ContestDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;

    public ContestDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public ContestEntity contestToContestEntity(Contest contest) {
        UserEntity createdBy = userDataAccessMapper.userToUserEntityHideSensitiveData(contest.getCreatedBy());
        UserEntity updatedBy = userDataAccessMapper.userToUserEntityHideSensitiveData(contest.getUpdatedBy());

        return ContestEntity.builder()
                .id(contest.getId().getValue())
                .name(contest.getName())
                .description(contest.getDescription())
                .thumbnailUrl(contest.getThumbnailUrl())
                .startTime(contest.getStartTime())
                .endTime(contest.getEndTime())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(contest.getCreatedAt())
                .updatedAt(contest.getUpdatedAt())
                .build();
    }

    public Contest contestEntityToContest(ContestEntity contestEntity) {
        User createdBy = userDataAccessMapper.userEntityToUserHideSensitiveData(contestEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUserHideSensitiveData(contestEntity.getUpdatedBy());
        return Contest.builder()
                .id(new ContestId(contestEntity.getId()))
                .name(contestEntity.getName())
                .description(contestEntity.getDescription())
                .thumbnailUrl(contestEntity.getThumbnailUrl())
                .startTime(contestEntity.getStartTime())
                .endTime(contestEntity.getEndTime())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(contestEntity.getCreatedAt())
                .updatedAt(contestEntity.getUpdatedAt())
                .build();
    }

    public Contest contestProjectionToContest(ContestProjection contestProjection) {
        ZonedDateTime startTime = contestProjection.getStartTime() == null
                ? null
                : ZonedDateTime.ofInstant(contestProjection.getStartTime(), ZoneId.of("UTC"));
        ZonedDateTime endTime = contestProjection.getEndTime() == null
                ? null
                : ZonedDateTime.ofInstant(contestProjection.getEndTime(), ZoneId.of("UTC"));
        ZonedDateTime createdAt = contestProjection.getCreatedAt() == null
                ? null
                : ZonedDateTime.ofInstant(contestProjection.getCreatedAt(), ZoneId.of("UTC"));
        ZonedDateTime updatedAt = contestProjection.getUpdatedAt() == null
                ? null
                : ZonedDateTime.ofInstant(contestProjection.getUpdatedAt(), ZoneId.of("UTC"));

        return Contest.builder()
                .id(new ContestId(contestProjection.getId()))
                .name(contestProjection.getName())
                .description(contestProjection.getDescription())
                .thumbnailUrl(contestProjection.getThumbnailUrl())
                .startTime(startTime)
                .endTime(endTime)
                .numOfParticipants(contestProjection.getNumOfParticipants())
                .createdBy(User.builder()
                        .id(new UserId(contestProjection.getCreatedById()))
                        .build())
                .updatedBy(User.builder()
                        .id(new UserId(contestProjection.getUpdatedById()))
                        .build())
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

    public List<String> splitWords(String search) {
        if(search == null) return null;

        ArrayList<String> words = Stream.of(search.split(" ")).filter(i-> !i.isEmpty()).collect(Collectors.toCollection(ArrayList::new));

        return words;
    }
}
