package io.github.ctorressoftware.academic.enrollment.security.domain.exception;

import io.github.ctorressoftware.academic.enrollment.security.domain.model.Username;

import java.util.UUID;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(Username username) {
        super("Invalid credentials for user: " + username.value());
    }

    public InvalidCredentialsException(UUID userId) {
        super("Invalid credentials for user id: " + userId.toString());
    }
}
