package io.github.ctorressoftware.academic.enrollment.security.domain.exception;

import org.springframework.security.core.AuthenticationException;

public class AuthTokenExpiredException extends AuthenticationException {

    public AuthTokenExpiredException(Throwable cause) {
        super("Authentication token has expired", cause);
    }
}
