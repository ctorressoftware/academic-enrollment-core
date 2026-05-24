package io.github.ctorressoftware.academic.enrollment.course.application.port.in.state.getall;

import io.github.ctorressoftware.academic.enrollment.course.domain.model.CourseState;

import java.util.List;

public record GetAllCourseStatesResult(List<CourseState> states) {}
