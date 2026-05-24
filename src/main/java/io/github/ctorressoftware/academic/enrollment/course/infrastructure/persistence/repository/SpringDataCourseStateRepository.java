package io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.entity.CourseStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataCourseStateRepository
        extends JpaRepository<CourseStateEntity, Short> {}
