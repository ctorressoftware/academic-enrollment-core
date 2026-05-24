package io.github.ctorressoftware.academic.enrollment.role.application.port.in.create;

public record CreateRoleCommand(
        short id,
        String code,
        String description
) {}
