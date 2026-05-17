package io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.out;

import io.github.ctorressoftware.academic.enrollment.courseoffering.domain.model.CourseState;

import java.util.List;

public interface CourseStateRepository {
    CourseState save(CourseState state);
    List<CourseState> getAll();
}
