package io.github.ctorressoftware.academic.enrollment.security.application.service;

import io.github.ctorressoftware.academic.enrollment.security.application.port.in.login.LoginCommand;
import io.github.ctorressoftware.academic.enrollment.security.application.port.in.login.LoginResult;
import io.github.ctorressoftware.academic.enrollment.security.application.port.in.login.LoginUseCase;
import io.github.ctorressoftware.academic.enrollment.security.domain.exception.InvalidCredentialsException;
import io.github.ctorressoftware.academic.enrollment.security.domain.model.Username;
import io.github.ctorressoftware.academic.enrollment.security.application.port.out.TokenIssuer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginUseCase {
    private final AuthenticationManager authManager;
    private final TokenIssuer tokenIssuer;

    public LoginService(
            AuthenticationManager authManager,
            TokenIssuer tokenIssuer) {
        this.authManager = authManager;
        this.tokenIssuer = tokenIssuer;
    }

    @Override
    public LoginResult login(LoginCommand command) {

        Username username = new Username(command.username());

        Authentication authToken = new UsernamePasswordAuthenticationToken(
                username.value(),
                command.password()
        );

        try {
            var auth = authManager.authenticate(authToken);

            if (!auth.isAuthenticated()) {
                throw new InvalidCredentialsException(username);
            }

            String accessToken = tokenIssuer.issueAccessToken(null);

            return new LoginResult(username.value(), accessToken);

        } catch (AuthenticationException e) {
            if (e instanceof BadCredentialsException) {
                throw new InvalidCredentialsException(username);
            }
            throw e;
        }
    }
}
