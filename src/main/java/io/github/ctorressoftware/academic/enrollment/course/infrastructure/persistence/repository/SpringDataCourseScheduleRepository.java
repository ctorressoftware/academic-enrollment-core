package io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.entity.CourseScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpringDataCourseScheduleRepository
        extends JpaRepository<CourseScheduleEntity, UUID> {
    List<CourseScheduleEntity> findAllByCourseOfferingId(UUID courseOfferingId);
}