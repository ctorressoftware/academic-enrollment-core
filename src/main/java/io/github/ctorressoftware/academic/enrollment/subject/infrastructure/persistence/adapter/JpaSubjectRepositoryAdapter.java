package io.github.ctorressoftware.academic.enrollment.subject.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.subject.application.port.out.SubjectRepository;
import io.github.ctorressoftware.academic.enrollment.subject.domain.model.Subject;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.persistence.entity.SubjectEntity;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.persistence.repository.SpringDataSubjectRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaSubjectRepositoryAdapter implements SubjectRepository {

    private final SpringDataSubjectRepository repository;

    public JpaSubjectRepositoryAdapter(SpringDataSubjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subject save(Subject subject) {
        SubjectEntity entity = repository.save(toEntity(subject));
        return toDomain(entity);
    }

    @Override
    public Optional<Subject> findByCode(String code) {
        return repository.findSubjectEntityByCode(code)
                .map(this::toDomain);
    }

    @Override
    public List<Subject> findAll(int page, int pageSize) {
        int pageIndex = Math.max(page - 1, 0);

        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        return repository.findAll(pageable).stream()
                .map(this::toDomain)
                .toList();
    }

    private Subject toDomain(SubjectEntity entity) {
        return Subject.restore(
                entity.getId(),
                entity.getCode(),
                entity.getDescription(),
                entity.isActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private SubjectEntity toEntity(Subject subject) {
        SubjectEntity entity = new SubjectEntity();
        entity.setId(subject.getId());
        entity.setCode(subject.getCode());
        entity.setDescription(subject.getDescription());
        entity.setActive(subject.isActive());
        entity.setCreatedAt(subject.getCreatedAt());
        entity.setUpdatedAt(subject.getUpdatedAt());
        return entity;
    }
}
