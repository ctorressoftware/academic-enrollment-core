package io.github.ctorressoftware.academic.enrollment.course.application.port.out;

import io.github.ctorressoftware.academic.enrollment.course.domain.model.CourseSchedule;

import java.util.List;
import java.util.UUID;

public interface CourseScheduleRepository {
    CourseSchedule save(CourseSchedule courseSchedule);
    List<CourseSchedule> findAllByCourseOfferingId(UUID courseOfferingId);
}
