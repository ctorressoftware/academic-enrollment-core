package io.github.ctorressoftware.academic.enrollment.role.application.service;

import io.github.ctorressoftware.academic.enrollment.role.application.port.in.findall.FindAllRolesResult;
import io.github.ctorressoftware.academic.enrollment.role.application.port.in.findall.FindAllRolesUseCase;
import io.github.ctorressoftware.academic.enrollment.role.application.port.out.RoleRepository;
import io.github.ctorressoftware.academic.enrollment.role.domain.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllRolesService implements FindAllRolesUseCase {

    private final RoleRepository roleRepository;

    public FindAllRolesService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public FindAllRolesResult findAll() {
        List<Role> roles = roleRepository.findAll();

        return new FindAllRolesResult(roles);
    }
}
