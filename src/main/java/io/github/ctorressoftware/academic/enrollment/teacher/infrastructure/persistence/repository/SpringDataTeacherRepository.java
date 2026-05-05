package io.github.ctorressoftware.academic.enrollment.teacher.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.teacher.infrastructure.persistence.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataTeacherRepository extends JpaRepository<TeacherEntity, UUID> {}