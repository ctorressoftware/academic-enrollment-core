package io.github.ctorressoftware.academic.enrollment.career.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.career.infrastructure.persistence.entity.CareerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataCareerRepository extends JpaRepository<CareerEntity, UUID> {
    Optional<CareerEntity> getByCode(String code);
}
