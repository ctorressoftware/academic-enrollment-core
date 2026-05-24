package io.github.ctorressoftware.academic.enrollment.role.application.service;

import io.github.ctorressoftware.academic.enrollment.role.application.port.in.create.CreateRoleCommand;
import io.github.ctorressoftware.academic.enrollment.role.application.port.in.create.CreateRoleResult;
import io.github.ctorressoftware.academic.enrollment.role.application.port.in.create.CreateRoleUseCase;
import io.github.ctorressoftware.academic.enrollment.role.application.port.out.RoleRepository;
import io.github.ctorressoftware.academic.enrollment.role.domain.exception.RoleAlreadyExistsException;
import io.github.ctorressoftware.academic.enrollment.role.domain.model.Role;
import org.springframework.stereotype.Service;

@Service
public class CreateRoleService implements CreateRoleUseCase {

    private final RoleRepository roleRepository;

    public CreateRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public CreateRoleResult create(CreateRoleCommand command) {

        roleRepository.findByCode(command.code())
                .ifPresent(role -> {
                    throw new RoleAlreadyExistsException(command.code());
                });

        Role role = Role.create(
                command.id(),
                command.code(),
                command.description()
        );

        Role saved = roleRepository.save(role);

        return new CreateRoleResult(saved);
    }
}
