package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.mapper.AuthDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class UserCreateHelper {
    private final AuthDomainService authDomainService;
    private final UserRepository userRepository;
    private final AuthDataMapper authDataMapper;

    public UserCreateHelper(AuthDomainService authDomainService, UserRepository userRepository, AuthDataMapper authDataMapper) {
        this.authDomainService = authDomainService;
        this.userRepository = userRepository;
        this.authDataMapper = authDataMapper;
    }

    @Transactional
    public User persisUser(CreateUserCommand createUserCommand) {
        User user = authDataMapper.createUserCommandToUser(createUserCommand);
        findUserWithEmail(user.getEmail());
        authDomainService.createUser(user);
        return saveUser(user);
    }

    private void findUserWithEmail(String email) {
        Optional<User> userResult = userRepository.findByEmail(email);
        if (userResult.isEmpty()) {
            log.warn("Found user with email: {}", email);
            throw new AuthDomainException("Found user with email: " + email);
        }
    }

    private User saveUser(User user) {
        User userResult = userRepository.save(user);
        if (userResult == null) {
            log.error("Could not save auth!");
            throw new AuthDomainException("Could not save auth!");
        }
        log.info("User is saved with id: {}", userResult.getId().getValue());
        return userResult;
    }
}
