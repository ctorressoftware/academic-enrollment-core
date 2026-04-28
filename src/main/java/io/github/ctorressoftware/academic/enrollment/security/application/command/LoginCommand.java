package io.github.ctorressoftware.academic.enrollment.security.application.command;

public record LoginCommand(
        String username,
        String password
) {}
