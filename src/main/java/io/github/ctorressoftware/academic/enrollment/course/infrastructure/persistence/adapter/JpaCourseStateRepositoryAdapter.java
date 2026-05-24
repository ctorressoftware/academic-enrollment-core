package io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.course.application.port.out.CourseStateRepository;
import io.github.ctorressoftware.academic.enrollment.course.domain.model.CourseState;
import io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.entity.CourseStateEntity;
import io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.repository.SpringDataCourseStateRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaCourseStateRepositoryAdapter implements CourseStateRepository {

    private final SpringDataCourseStateRepository repository;

    public JpaCourseStateRepositoryAdapter(
            SpringDataCourseStateRepository repository) {
        this.repository = repository;
    }

    @Override
    public CourseState save(CourseState state) {
        CourseStateEntity saved = repository.save(toEntity(state));
        return toDomain(saved);
    }

    @Override
    public List<CourseState> getAll() {
        return repository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    private CourseState toDomain(CourseStateEntity entity) {

        return CourseState.restore(
                entity.getId(),
                entity.getCode(),
                entity.getDescription(),
                entity.getActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private CourseStateEntity toEntity(CourseState state) {
        CourseStateEntity entity = new CourseStateEntity();
        entity.setId(state.getId());
        entity.setCode(state.getCode());
        entity.setDescription(state.getDescription());
        entity.setActive(state.isActive());
        entity.setCreatedAt(state.getCreatedAt());
        entity.setUpdatedAt(state.getUpdatedAt());
        return entity;
    }
}
