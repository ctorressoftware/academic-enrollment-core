package io.github.ctorressoftware.academic.enrollment.security.application.port.in.register;

import java.util.UUID;

public record RegisterUserCommand(
        UUID personId,
        short roleId,
        String username,
        String password
) {}
