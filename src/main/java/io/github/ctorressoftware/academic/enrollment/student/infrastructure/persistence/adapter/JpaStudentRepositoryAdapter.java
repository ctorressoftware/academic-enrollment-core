package io.github.ctorressoftware.academic.enrollment.student.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.student.application.port.out.StudentRepository;
import io.github.ctorressoftware.academic.enrollment.student.domain.model.Student;
import io.github.ctorressoftware.academic.enrollment.student.infrastructure.persistence.entity.StudentEntity;
import io.github.ctorressoftware.academic.enrollment.student.infrastructure.persistence.repository.SpringDataStudentRepository;
import org.springframework.stereotype.Component;

@Component
public class JpaStudentRepositoryAdapter implements StudentRepository {

    private final SpringDataStudentRepository repository;

    public JpaStudentRepositoryAdapter(SpringDataStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student save(Student student) {
        StudentEntity entity = toEntity(student);
        StudentEntity saved = repository.save(entity);
        return toDomain(saved);
    }

    private Student toDomain(StudentEntity entity) {
        return Student.restore(
                entity.getId(),
                entity.getPersonId(),
                entity.getCareerId(),
                entity.isActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private StudentEntity toEntity(Student student) {
        StudentEntity entity = new StudentEntity();
        entity.setId(student.getId());
        entity.setPersonId(student.getPersonId());
        entity.setCareerId(student.getCareerId());
        entity.setActive(student.isActive());
        entity.setCreatedAt(student.getCreatedAt());
        entity.setUpdatedAt(student.getUpdatedAt());
        return entity;
    }
}
