package io.github.ctorressoftware.academic.enrollment.role.application.port.in.findbycode;

import io.github.ctorressoftware.academic.enrollment.role.application.port.in.findall.FindAllRolesResult;

public interface FindRoleByCodeUseCase {
    FindRoleByCodeResult findByCode(String code);
}
