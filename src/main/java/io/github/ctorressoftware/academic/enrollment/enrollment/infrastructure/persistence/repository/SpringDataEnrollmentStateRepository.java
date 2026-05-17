package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.persistence.entity.EnrollmentStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataEnrollmentStateRepository
        extends JpaRepository<EnrollmentStateEntity, Short> {}
