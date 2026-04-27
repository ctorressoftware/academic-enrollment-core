package io.github.ctorressoftware.academic.enrollment.security.application.command;

import java.util.UUID;

public record RegisterUserCommand(
        UUID personId,
        String username,
        String password
) {}
