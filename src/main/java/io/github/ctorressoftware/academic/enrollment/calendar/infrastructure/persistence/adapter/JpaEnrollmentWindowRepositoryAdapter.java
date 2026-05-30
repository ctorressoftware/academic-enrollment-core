package io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.calendar.application.port.out.EnrollmentWindowRepository;
import io.github.ctorressoftware.academic.enrollment.calendar.domain.model.EnrollmentWindow;
import io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.persistence.entity.EnrollmentWindowEntity;
import io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.persistence.repository.SpringDataEnrollmentWindowRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class JpaEnrollmentWindowRepositoryAdapter implements EnrollmentWindowRepository {

    private final SpringDataEnrollmentWindowRepository repository;

    public JpaEnrollmentWindowRepositoryAdapter(SpringDataEnrollmentWindowRepository repository) {
        this.repository = repository;
    }

    @Override
    public EnrollmentWindow save(EnrollmentWindow enrollmentWindow) {
        EnrollmentWindowEntity saved = repository.save(toEntity(enrollmentWindow));
        return toDomain(saved);
    }

    @Override
    public Optional<EnrollmentWindow> findActiveByAcademicPeriodId(UUID academicPeriodId) {
        return repository.findByAcademicPeriodIdAndActiveIsTrue(academicPeriodId)
                .map(this::toDomain);
    }

    private EnrollmentWindow toDomain(EnrollmentWindowEntity entity) {
        return EnrollmentWindow.restore(
                entity.getId(),
                entity.getAcademicPeriodId(),
                entity.getType(),
                entity.getOpensAt(),
                entity.getClosesAt(),
                entity.getActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private EnrollmentWindowEntity toEntity(EnrollmentWindow enrollmentWindow) {
        EnrollmentWindowEntity entity = new EnrollmentWindowEntity();
        entity.setId(enrollmentWindow.getId());
        entity.setAcademicPeriodId(enrollmentWindow.getAcademicPeriodId());
        entity.setType(enrollmentWindow.getType());
        entity.setOpensAt(enrollmentWindow.getOpensAt());
        entity.setClosesAt(enrollmentWindow.getClosesAt());
        entity.setActive(enrollmentWindow.isActive());
        entity.setCreatedAt(enrollmentWindow.getCreatedAt());
        entity.setUpdatedAt(enrollmentWindow.getUpdatedAt());
        return entity;
    }
}