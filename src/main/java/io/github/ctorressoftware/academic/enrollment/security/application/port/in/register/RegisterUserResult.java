package io.github.ctorressoftware.academic.enrollment.security.application.port.in.register;

import java.util.UUID;

public record RegisterUserResult(
        UUID userId,
        UUID personId,
        String username,
        String accessToken
) {}
