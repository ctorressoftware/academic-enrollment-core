package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.persistence.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpringDataEnrollmentRepository
        extends JpaRepository<EnrollmentEntity, UUID> {
    List<EnrollmentEntity> getAllByStudentId(UUID studentId);

    @Query("""
    SELECT CASE WHEN COUNT(e) > 0 THEN TRUE ELSE FALSE END
    FROM enrollment e,
         course_offering existing,
         course_offering candidate,
         course_schedule es,
         course_schedule cs
    WHERE e.studentId = :studentId
      AND existing.id = e.courseOfferingId
      AND candidate.id = :candidateCourseOfferingId
      AND existing.academicPeriodId = candidate.academicPeriodId
      AND es.courseOfferingId = existing.id
      AND cs.courseOfferingId = candidate.id
      AND es.weekDay = cs.weekDay
      AND es.startTime < cs.endTime
      AND es.endTime > cs.startTime
    """)
    boolean existsEnrollmentScheduleConflict(
            UUID studentId,
            UUID candidateCourseOfferingId
    );
}
