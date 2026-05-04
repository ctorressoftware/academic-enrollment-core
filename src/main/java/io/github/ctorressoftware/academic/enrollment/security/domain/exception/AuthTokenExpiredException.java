package io.github.ctorressoftware.academic.enrollment.security.domain.exception;

public class AuthTokenExpiredException extends RuntimeException {

    public AuthTokenExpiredException(Throwable cause) {
        super("Authentication token has expired", cause);
    }
}
