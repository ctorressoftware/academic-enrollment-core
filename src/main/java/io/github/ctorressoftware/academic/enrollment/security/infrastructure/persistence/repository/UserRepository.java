package io.github.ctorressoftware.academic.enrollment.security.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.security.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {}
