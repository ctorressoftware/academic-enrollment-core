package io.github.ctorressoftware.academic.enrollment.role.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.role.application.port.out.RoleRepository;
import io.github.ctorressoftware.academic.enrollment.role.domain.model.Role;
import io.github.ctorressoftware.academic.enrollment.role.infrastructure.persistence.entity.RoleEntity;
import io.github.ctorressoftware.academic.enrollment.role.infrastructure.persistence.repository.SpringDataRoleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaRoleRepositoryAdapter implements RoleRepository {

    private final SpringDataRoleRepository repository;

    public JpaRoleRepositoryAdapter(SpringDataRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role save(Role role) {
        RoleEntity saved = repository.save(toEntity(role));
        return toDomain(saved);
    }

    @Override
    public Optional<Role> findById(short id) {
        return repository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public Optional<Role> findByCode(String code) {
        return repository.findByCode(code)
                .map(this::toDomain);
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    private Role toDomain(RoleEntity entity) {
        return Role.restore(
                entity.getId(),
                entity.getCode(),
                entity.getDescription(),
                entity.getActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private RoleEntity toEntity(Role role) {
        RoleEntity entity = new RoleEntity();
        entity.setId(role.getId());
        entity.setCode(role.getCode());
        entity.setDescription(role.getDescription());
        entity.setActive(role.isActive());
        entity.setCreatedAt(role.getCreatedAt());
        entity.setUpdatedAt(role.getUpdatedAt());
        return entity;
    }
}
