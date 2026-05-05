package io.github.ctorressoftware.academic.enrollment.student.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.student.infrastructure.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataStudentRepository extends JpaRepository<StudentEntity, UUID> {}