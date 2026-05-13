package io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.person.application.port.out.GenderRepository;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.gender.Gender;
import io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.entity.GenderEntity;
import io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.repository.SpringDataGenderRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaGenderRepositoryAdapter implements GenderRepository {

    private final SpringDataGenderRepository repository;

    public JpaGenderRepositoryAdapter(SpringDataGenderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Gender save(Gender gender) {
        GenderEntity saved = repository.save(toEntity(gender));
        return toDomain(saved);
    }

    @Override
    public Optional<Gender> getByCode(String code) {
        return repository.getByCode(code);
    }

    @Override
    public List<Gender> getAllByCodeAndIsActive(String code) {
        List<GenderEntity> genders = repository.getAllByCodeAndActiveIsTrue(code);
        return toDomain(genders);
    }

    private List<Gender> toDomain(List<GenderEntity> entities) {
        return entities.stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Gender update(Gender gender) {

        GenderEntity entity = repository.update(
                gender.getId(),
                gender.getCode(),
                gender.getDescription(),
                gender.isActive(),
                gender.getUpdatedAt()
        );

        return toDomain(entity);
    }

    @Override
    public void remove(short id) {
        repository.removeById(id);
    }

    private GenderEntity toEntity(Gender gender) {
        GenderEntity entity = new GenderEntity();
        entity.setId(gender.getId());
        entity.setCode(gender.getCode());
        entity.setDescription(gender.getDescription());
        entity.setActive(gender.isActive());
        entity.setCreatedAt(gender.getCreatedAt());
        entity.setUpdatedAt(gender.getUpdatedAt());
        return entity;
    }

    private Gender toDomain(GenderEntity entity) {
        return Gender.restore(
                entity.getId(),
                entity.getCode(),
                entity.getDescription(),
                entity.getActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
