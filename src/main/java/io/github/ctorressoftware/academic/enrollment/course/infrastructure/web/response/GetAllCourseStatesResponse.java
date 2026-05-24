package io.github.ctorressoftware.academic.enrollment.course.infrastructure.web.response;

import io.github.ctorressoftware.academic.enrollment.course.domain.model.CourseState;

import java.util.List;

public record GetAllCourseStatesResponse(List<CourseState> states) {}
