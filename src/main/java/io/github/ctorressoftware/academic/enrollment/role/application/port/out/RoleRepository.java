package io.github.ctorressoftware.academic.enrollment.role.application.port.out;

import io.github.ctorressoftware.academic.enrollment.role.domain.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {
    Role save(Role role);
    Optional<Role> findById(short id);
    Optional<Role> findByCode(String code);
    List<Role> findAll();
}
