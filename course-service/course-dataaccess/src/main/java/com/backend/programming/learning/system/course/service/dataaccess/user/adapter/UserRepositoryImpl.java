package com.backend.programming.learning.system.course.service.dataaccess.user.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.entity.User;
import com.backend.programming.learning.system.ports.output.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository, UserDataAccessMapper userDataAccessMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userDataAccessMapper = userDataAccessMapper;
    }


    @Override
    public User saveUser(User user) {
        return userDataAccessMapper
                .userEntityToUser(userJpaRepository
                        .save(userDataAccessMapper
                                .userToUserEntity(user)));
    }

    @Override
    public Optional<User> findUser(UUID userId) {
        return userJpaRepository.findById(userId)
                .map(userDataAccessMapper::userEntityToUser);
    }
}
