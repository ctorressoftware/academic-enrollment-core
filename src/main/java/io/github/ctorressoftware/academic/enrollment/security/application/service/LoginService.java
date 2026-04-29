package io.github.ctorressoftware.academic.enrollment.security.application.service;

import io.github.ctorressoftware.academic.enrollment.security.application.command.LoginCommand;
import io.github.ctorressoftware.academic.enrollment.security.domain.exception.InvalidCredentialsException;
import io.github.ctorressoftware.academic.enrollment.security.application.result.LoginResult;
import io.github.ctorressoftware.academic.enrollment.security.application.usecase.LoginUseCase;
import io.github.ctorressoftware.academic.enrollment.security.domain.model.PasswordHash;
import io.github.ctorressoftware.academic.enrollment.security.domain.model.User;
import io.github.ctorressoftware.academic.enrollment.security.domain.model.Username;
import io.github.ctorressoftware.academic.enrollment.security.domain.ports.PasswordHasher;
import io.github.ctorressoftware.academic.enrollment.security.domain.ports.TokenIssuer;
import io.github.ctorressoftware.academic.enrollment.security.domain.ports.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements LoginUseCase {

    private final UserRepository repository;
    private final AuthenticationManager authManager;
    private final TokenIssuer tokenIssuer;
    private final PasswordHasher passwordHasher;

    public LoginService(
            UserRepository repository,
            AuthenticationManager authManager,
            TokenIssuer tokenIssuer,
            PasswordHasher passwordHasher) {
        this.repository = repository;
        this.authManager = authManager;
        this.tokenIssuer = tokenIssuer;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public LoginResult login(LoginCommand command) {

        Username username = new Username(command.username());
        PasswordHash passwordHash = passwordHasher.hash(command.password());

        User user = repository.findByUsername(username)
                .orElseThrow(() -> new InvalidCredentialsException(username));

        Authentication authToken = new UsernamePasswordAuthenticationToken(
                user,
                passwordHash.value(),
                List.of(new SimpleGrantedAuthority("ROLE_STUDENT"))
        );

        var auth = authManager.authenticate(authToken);

        if (!auth.isAuthenticated()) {
            throw new InvalidCredentialsException(username);
        }

        String accessToken = tokenIssuer.issueAccessToken((User) auth.getPrincipal());

        return new LoginResult(username.value(), accessToken);
    }
}
