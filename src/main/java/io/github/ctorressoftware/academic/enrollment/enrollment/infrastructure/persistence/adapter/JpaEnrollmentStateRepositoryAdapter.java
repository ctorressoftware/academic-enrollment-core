package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.out.EnrollmentStateRepository;
import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.EnrollmentState;
import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.persistence.entity.EnrollmentStateEntity;
import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.persistence.repository.SpringDataEnrollmentStateRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaEnrollmentStateRepositoryAdapter implements EnrollmentStateRepository {

    private final SpringDataEnrollmentStateRepository repository;

    public JpaEnrollmentStateRepositoryAdapter(
            SpringDataEnrollmentStateRepository repository) {
        this.repository = repository;
    }

    @Override
    public EnrollmentState save(EnrollmentState state) {
        EnrollmentStateEntity saved = repository.save(toEntity(state));
        return toDomain(saved);
    }

    @Override
    public List<EnrollmentState> getAll() {
        return repository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    private EnrollmentState toDomain(EnrollmentStateEntity entity) {

        return EnrollmentState.restore(
                entity.getId(),
                entity.getCode(),
                entity.getDescription(),
                entity.getActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private EnrollmentStateEntity toEntity(EnrollmentState state) {
        EnrollmentStateEntity entity = new EnrollmentStateEntity();
        entity.setId(state.getId());
        entity.setCode(state.getCode());
        entity.setDescription(state.getDescription());
        entity.setActive(state.isActive());
        entity.setCreatedAt(state.getCreatedAt());
        entity.setUpdatedAt(state.getUpdatedAt());
        return entity;
    }
}
