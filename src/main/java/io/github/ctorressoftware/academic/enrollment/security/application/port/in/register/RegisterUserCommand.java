package io.github.ctorressoftware.academic.enrollment.security.application.port.in.register;

import java.util.UUID;

public record RegisterUserCommand(
        UUID personId,
        String username,
        String password
) {}
