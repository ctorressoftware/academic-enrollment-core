package io.github.ctorressoftware.academic.enrollment.security.application.service;

import io.github.ctorressoftware.academic.enrollment.security.application.command.RegisterUserCommand;
import io.github.ctorressoftware.academic.enrollment.security.application.result.RegisterUserResult;
import io.github.ctorressoftware.academic.enrollment.security.application.usecase.RegisterUserUseCase;
import io.github.ctorressoftware.academic.enrollment.security.domain.exception.UserAlreadyExistsException;
import io.github.ctorressoftware.academic.enrollment.security.domain.model.PasswordHash;
import io.github.ctorressoftware.academic.enrollment.security.domain.model.User;
import io.github.ctorressoftware.academic.enrollment.security.domain.model.Username;
import io.github.ctorressoftware.academic.enrollment.security.domain.ports.PasswordHasher;
import io.github.ctorressoftware.academic.enrollment.security.domain.ports.TokenIssuer;
import io.github.ctorressoftware.academic.enrollment.security.domain.ports.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RegisterUserService implements RegisterUserUseCase {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;
    private final TokenIssuer tokenIssuer;

    public RegisterUserService(
            UserRepository userRepository,
            PasswordHasher passwordHasher,
            TokenIssuer tokenIssuer) {
        this.userRepository = Objects.requireNonNull(userRepository);
        this.passwordHasher = Objects.requireNonNull(passwordHasher);
        this.tokenIssuer = Objects.requireNonNull(tokenIssuer);
    }

    @Override
    public RegisterUserResult register(RegisterUserCommand command) {
        Objects.requireNonNull(command, "register command is null");

        Username username = new Username(command.username());

        if (userRepository.existsByUsername(username)) {
            throw new UserAlreadyExistsException(username);
        }

        PasswordHash passwordHash = passwordHasher.hash(command.password());
        User user = User.create(command.personId(), username, passwordHash);
        User savedUser = userRepository.save(user);
        String accessToken = tokenIssuer.issueAccessToken(savedUser);

        return new RegisterUserResult(
                savedUser.getId(),
                savedUser.getPersonId(),
                savedUser.getUsername().value(),
                accessToken
        );
    }
}
