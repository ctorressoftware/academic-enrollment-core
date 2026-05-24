package io.github.ctorressoftware.academic.enrollment.courseoffering.infrastructure.web.response;

import io.github.ctorressoftware.academic.enrollment.courseoffering.domain.model.CourseState;

import java.util.List;

public record GetAllCourseStatesResponse(List<CourseState> states) {}
