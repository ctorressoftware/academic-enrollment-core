package io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.state.getall;

import io.github.ctorressoftware.academic.enrollment.courseoffering.domain.model.CourseState;

import java.util.List;

public record GetAllCourseStatesResult(List<CourseState> states) {}
