package io.github.ctorressoftware.academic.enrollment.security.domain.exception;

import io.github.ctorressoftware.academic.enrollment.security.domain.model.Username;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(Username username) {
        super("Username already exists: " + username.value());
    }
}
