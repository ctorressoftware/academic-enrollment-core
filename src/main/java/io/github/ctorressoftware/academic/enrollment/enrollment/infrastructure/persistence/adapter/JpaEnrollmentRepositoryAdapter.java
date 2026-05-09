package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.out.EnrollmentRepository;
import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.Enrollment;
import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.persistence.entity.EnrollmentEntity;
import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.persistence.repository.SpringDataEnrollmentRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JpaEnrollmentRepositoryAdapter implements EnrollmentRepository {

    private final SpringDataEnrollmentRepository repository;

    public JpaEnrollmentRepositoryAdapter(SpringDataEnrollmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        EnrollmentEntity saved = repository.save(toEntity(enrollment));
        return toDomain(saved);
    }

    @Override
    public List<Enrollment> getAllByStudentId(UUID studentId) {

        List<EnrollmentEntity> enrollmentEntities =
                repository.getAllByStudentId(studentId);

        return enrollmentEntities.stream()
                .map(this::toDomain)
                .toList();
    }

    private Enrollment toDomain(EnrollmentEntity entity) {

        return Enrollment.restore(
                entity.getId(),
                entity.getStudentId(),
                entity.getCourseOfferingId(),
                entity.getEnrollmentStateId(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private EnrollmentEntity toEntity(Enrollment enrollment) {
        EnrollmentEntity entity = new EnrollmentEntity();
        entity.setId(enrollment.getId());
        entity.setStudentId(enrollment.getStudentId());
        entity.setCourseOfferingId(enrollment.getCourseOfferingId());
        entity.setEnrollmentStateId(enrollment.getEnrollmentStateId());
        entity.setCreatedAt(enrollment.getCreatedAt());
        entity.setUpdatedAt(enrollment.getUpdatedAt());
        return entity;
    }
}
