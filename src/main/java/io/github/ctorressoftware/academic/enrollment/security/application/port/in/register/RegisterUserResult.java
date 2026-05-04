package io.github.ctorressoftware.academic.enrollment.security.application.result;

import java.util.UUID;

public record RegisterUserResult(
        UUID userId,
        UUID personId,
        String username,
        String accessToken
) {}
