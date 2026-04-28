package io.github.ctorressoftware.academic.enrollment.security.application.result;

public record LoginResult(
        String username,
        String accessToken
) {}
