package io.github.ctorressoftware.academic.enrollment.career.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.career.application.port.out.CareerRepository;
import io.github.ctorressoftware.academic.enrollment.career.domain.model.Career;
import io.github.ctorressoftware.academic.enrollment.career.infrastructure.persistence.entity.CareerEntity;
import io.github.ctorressoftware.academic.enrollment.career.infrastructure.persistence.repository.SpringDataCareerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaCareerRepositoryAdapter implements CareerRepository {

    private final SpringDataCareerRepository repository;

    public JpaCareerRepositoryAdapter(SpringDataCareerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Career save(Career career) {
        CareerEntity saved = repository.save(toEntity(career));
        return toDomain(saved);
    }

    @Override
    public Optional<Career> getByCode(String code) {
        return repository.getByCode(code)
                .map(this::toDomain);
    }

    @Override
    public List<Career> getAll() {
        return repository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    private Career toDomain(CareerEntity entity) {

        return Career.restore(
                entity.getId(),
                entity.getCode(),
                entity.getDescription(),
                entity.getActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private CareerEntity toEntity(Career career) {
        CareerEntity entity = new CareerEntity();
        entity.setId(career.getId());
        entity.setCode(career.getCode());
        entity.setDescription(career.getDescription());
        entity.setActive(career.isActive());
        entity.setCreatedAt(career.getCreatedAt());
        entity.setUpdatedAt(career.getUpdatedAt());
        return entity;
    }
}
