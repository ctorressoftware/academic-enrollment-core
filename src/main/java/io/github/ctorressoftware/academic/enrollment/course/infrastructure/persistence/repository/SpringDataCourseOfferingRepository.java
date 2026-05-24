package io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.entity.CourseOfferingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpringDataCourseOfferingRepository
        extends JpaRepository<CourseOfferingEntity, UUID> {
    List<CourseOfferingEntity> getAllByGroupCode(String groupCode);
}
