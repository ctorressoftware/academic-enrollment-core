package io.github.ctorressoftware.academic.enrollment.security.domain.exception;

public class InvalidAuthTokenException extends RuntimeException {

    public InvalidAuthTokenException(Throwable cause) {
        super("Invalid authentication token", cause);
    }
}
