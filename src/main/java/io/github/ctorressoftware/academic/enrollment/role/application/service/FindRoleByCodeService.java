package io.github.ctorressoftware.academic.enrollment.role.application.service;

import io.github.ctorressoftware.academic.enrollment.role.application.port.in.findbycode.FindRoleByCodeResult;
import io.github.ctorressoftware.academic.enrollment.role.application.port.in.findbycode.FindRoleByCodeUseCase;
import io.github.ctorressoftware.academic.enrollment.role.application.port.out.RoleRepository;
import io.github.ctorressoftware.academic.enrollment.role.domain.exception.RoleNotFoundException;
import io.github.ctorressoftware.academic.enrollment.role.domain.model.Role;
import org.springframework.stereotype.Service;

@Service
public class FindRoleByCodeService implements FindRoleByCodeUseCase {

    private final RoleRepository roleRepository;

    public FindRoleByCodeService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public FindRoleByCodeResult findByCode(String code) {
        Role role = roleRepository.findByCode(code)
                .orElseThrow(() -> new RoleNotFoundException(code));

        return new FindRoleByCodeResult(role);
    }
}
