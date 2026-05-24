package io.github.ctorressoftware.academic.enrollment.course.infrastructure.web.response;

import io.github.ctorressoftware.academic.enrollment.course.domain.model.CourseSchedule;

import java.util.List;

public record FindAllByCourseOfferingIdResponse(List<CourseSchedule> courseScheduleList) {}
