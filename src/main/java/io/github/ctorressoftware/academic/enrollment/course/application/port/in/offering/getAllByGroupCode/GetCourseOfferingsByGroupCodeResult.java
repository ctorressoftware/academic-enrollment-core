package io.github.ctorressoftware.academic.enrollment.course.application.port.in.offering.getAllByGroupCode;

import io.github.ctorressoftware.academic.enrollment.course.domain.model.CourseOffering;

import java.util.List;

public record GetCourseOfferingsByGroupCodeResult(List<CourseOffering> courseOfferings) {}
