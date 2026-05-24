package io.github.ctorressoftware.academic.enrollment.role.infrastructure.web.request;

public record CreateRoleRequest(
        short id,
        String code,
        String description
) {}
