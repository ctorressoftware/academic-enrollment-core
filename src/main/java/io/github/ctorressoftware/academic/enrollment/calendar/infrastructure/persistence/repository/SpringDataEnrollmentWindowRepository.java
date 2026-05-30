package io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.persistence.entity.EnrollmentWindowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataEnrollmentWindowRepository
        extends JpaRepository<EnrollmentWindowEntity, UUID> {

    Optional<EnrollmentWindowEntity> findByAcademicPeriodIdAndActiveIsTrue(UUID academicPeriodId);
}
