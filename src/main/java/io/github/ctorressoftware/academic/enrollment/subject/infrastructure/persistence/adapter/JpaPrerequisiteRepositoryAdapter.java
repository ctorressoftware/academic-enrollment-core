package io.github.ctorressoftware.academic.enrollment.subject.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.subject.application.port.out.PrerequisiteRepository;
import io.github.ctorressoftware.academic.enrollment.subject.domain.model.Prerequisite;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.persistence.entity.PrerequisiteEntity;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.persistence.repository.SpringDataPrerequisiteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class JpaPrerequisiteRepositoryAdapter implements PrerequisiteRepository {

    private final SpringDataPrerequisiteRepository repository;

    public JpaPrerequisiteRepositoryAdapter(SpringDataPrerequisiteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Prerequisite save(Prerequisite prerequisite) {
        PrerequisiteEntity saved = repository.save(toEntity(prerequisite));
        return toDomain(saved);
    }

    @Override
    public List<Prerequisite> findAllBySubjectId(UUID subjectId) {
        List<PrerequisiteEntity> prerequisites = repository.getAllBySubjectId(subjectId);
        return prerequisites.stream()
                .map(this::toDomain)
                .toList();
    }

    private Prerequisite toDomain(PrerequisiteEntity entity) {
        return Prerequisite.restore(
                entity.getId(),
                entity.getSubjectId(),
                entity.getPrerequisiteSubjectId(),
                entity.getCareerId(),
                entity.getDescription(),
                entity.getActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private PrerequisiteEntity toEntity(Prerequisite prerequisite) {
        PrerequisiteEntity entity = new PrerequisiteEntity();
        entity.setId(prerequisite.getId());
        entity.setSubjectId(prerequisite.getSubjectId());
        entity.setPrerequisiteSubjectId(prerequisite.getPrerequisiteSubjectId());
        entity.setCareerId(prerequisite.getCareerId());
        entity.setDescription(prerequisite.getDescription());
        entity.setActive(prerequisite.isActive());
        entity.setCreatedAt(prerequisite.getCreatedAt());
        entity.setUpdatedAt(prerequisite.getUpdatedAt());
        return entity;
    }
}
