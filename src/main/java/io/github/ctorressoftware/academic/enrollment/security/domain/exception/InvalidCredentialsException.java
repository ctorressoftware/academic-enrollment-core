package io.github.ctorressoftware.academic.enrollment.security.domain.exception;

import io.github.ctorressoftware.academic.enrollment.security.domain.model.Username;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(Username username) {
        super("Invalid credentials for user: " + username.value());
    }
}
