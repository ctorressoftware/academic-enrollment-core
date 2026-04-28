package io.github.ctorressoftware.academic.enrollment.security.application.service;

import io.github.ctorressoftware.academic.enrollment.security.application.command.LoginCommand;
import io.github.ctorressoftware.academic.enrollment.security.application.result.LoginResult;
import io.github.ctorressoftware.academic.enrollment.security.application.usecase.LoginUseCase;
import io.github.ctorressoftware.academic.enrollment.security.domain.ports.TokenIssuer;
import io.github.ctorressoftware.academic.enrollment.security.domain.ports.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginUseCase {

    private final UserRepository repository;
    private final AuthenticationManager authManager;
    private final TokenIssuer tokenIssuer;

    public LoginService(
            UserRepository repository,
            AuthenticationManager authManager,
            TokenIssuer tokenIssuer) {
        this.repository = repository;
        this.authManager = authManager;
        this.tokenIssuer = tokenIssuer;
    }

    @Override
    public LoginResult login(LoginCommand command) {
        return null;
    }
}
