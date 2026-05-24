package io.github.ctorressoftware.academic.enrollment.role.application.port.in.findall;

import io.github.ctorressoftware.academic.enrollment.role.domain.model.Role;

import java.util.List;

public record FindAllRolesResult(List<Role> roles) {}
