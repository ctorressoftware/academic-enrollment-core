package io.github.ctorressoftware.academic.enrollment.role.infrastructure.web.response;

import io.github.ctorressoftware.academic.enrollment.role.domain.model.Role;

import java.util.List;

public record FindAllRolesResponse(List<Role> roles) {}
