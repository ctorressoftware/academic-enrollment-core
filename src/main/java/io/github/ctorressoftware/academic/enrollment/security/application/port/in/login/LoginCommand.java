package io.github.ctorressoftware.academic.enrollment.security.application.port.in.login;

public record LoginCommand(
        String username,
        String password
) {}
