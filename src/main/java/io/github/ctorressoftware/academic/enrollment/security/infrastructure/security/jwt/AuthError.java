package io.github.ctorressoftware.academic.enrollment.security.infrastructure.security.jwt;

public record AuthError(
        String code,
        String message)
{}
