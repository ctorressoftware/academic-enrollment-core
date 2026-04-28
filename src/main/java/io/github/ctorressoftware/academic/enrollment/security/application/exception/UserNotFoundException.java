package io.github.ctorressoftware.academic.enrollment.security.application.exception;

import io.github.ctorressoftware.academic.enrollment.security.domain.model.Username;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Username username) {
        super("User not found: " + username.value());
    }
}
