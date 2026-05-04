package io.github.ctorressoftware.academic.enrollment.security.domain.exception;

import org.springframework.security.core.AuthenticationException;

public class InvalidAuthTokenException extends AuthenticationException {

    public InvalidAuthTokenException(Throwable cause) {
        super("Invalid authentication token", cause);
    }
}
