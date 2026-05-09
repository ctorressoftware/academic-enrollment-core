package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.persistence.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpringDataEnrollmentRepository
        extends JpaRepository<EnrollmentEntity, UUID> {
    List<EnrollmentEntity> getAllByStudentId(UUID studentId);
}
