package io.github.ctorressoftware.academic.enrollment.security.infrastructure.web.exception;

import io.github.ctorressoftware.academic.enrollment.security.domain.exception.AuthTokenExpiredException;
import io.github.ctorressoftware.academic.enrollment.security.domain.exception.InvalidAuthTokenException;
import io.github.ctorressoftware.academic.enrollment.security.domain.exception.InvalidCredentialsException;
import io.github.ctorressoftware.academic.enrollment.security.domain.exception.UserAlreadyExistsException;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SecurityExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(SecurityExceptionHandler.class);

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Void>> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        log.warn("Username already exists: {}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ApiResponse.error(
                        "USERNAME_ALREADY_EXISTS",
                        "Username already exists",
                        null
                ));
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ApiResponse<Void>> handleInvalidCredentialsException(InvalidCredentialsException e) {
        log.warn(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(ApiResponse.error(
                        "INVALID_CREDENTIALS",
                        "Invalid credentials",
                        null
                ));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiResponse<Void>> handleAuthenticationException(AuthenticationException e) {
        log.error("Authentication failed: {}", e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error(
                        "AUTHENTICATION_ERROR",
                        "Authentication failed",
                        null
                ));
    }

    @ExceptionHandler(AuthTokenExpiredException.class)
    public ResponseEntity<ApiResponse<Void>> handleAuthTokenExpiredException(AuthTokenExpiredException e) {
        log.warn("Authentication token has expired: {}", e.getClass().getSimpleName());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error(
                        "AUTH_TOKEN_EXPIRED",
                        e.getMessage(),
                        null
                ));
    }

    @ExceptionHandler(InvalidAuthTokenException.class)
    public ResponseEntity<ApiResponse<Void>> handleInvalidAuthTokenException(InvalidAuthTokenException e) {
        log.warn("Invalid authentication token to validate user: {}", e.getClass().getSimpleName());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error(
                        "INVALID_TOKEN",
                        e.getMessage(),
                        null
                ));
    }
}