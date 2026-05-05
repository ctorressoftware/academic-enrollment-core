package io.github.ctorressoftware.academic.enrollment.teacher.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.teacher.application.port.out.TeacherRepository;
import io.github.ctorressoftware.academic.enrollment.teacher.domain.model.Teacher;
import io.github.ctorressoftware.academic.enrollment.teacher.infrastructure.persistence.entity.TeacherEntity;
import io.github.ctorressoftware.academic.enrollment.teacher.infrastructure.persistence.repository.SpringDataTeacherRepository;
import org.springframework.stereotype.Component;

@Component
public class JpaTeacherRepositoryAdapter implements TeacherRepository {

    private final SpringDataTeacherRepository repository;

    public JpaTeacherRepositoryAdapter(SpringDataTeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Teacher save(Teacher teacher) {
        TeacherEntity entity = toEntity(teacher);
        TeacherEntity saved = repository.save(entity);
        return toDomain(saved);
    }

    private Teacher toDomain(TeacherEntity entity) {
        return Teacher.restore(
                entity.getId(),
                entity.getPersonId(),
                entity.isActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private TeacherEntity toEntity(Teacher teacher) {
        TeacherEntity entity = new TeacherEntity();
        entity.setId(teacher.getId());
        entity.setPersonId(teacher.getPersonId());
        entity.setActive(teacher.isActive());
        entity.setCreatedAt(teacher.getCreatedAt());
        entity.setUpdatedAt(teacher.getUpdatedAt());
        return entity;
    }
}
