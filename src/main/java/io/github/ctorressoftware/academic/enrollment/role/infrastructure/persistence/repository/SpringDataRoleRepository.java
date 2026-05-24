package io.github.ctorressoftware.academic.enrollment.role.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.role.infrastructure.persistence.entity.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataRoleRepository extends JpaRepository<RoleEntity, Short> {
    @Override
    Page<RoleEntity> findAll(Pageable pageable);
    Optional<RoleEntity> findByCode(String code);
}
