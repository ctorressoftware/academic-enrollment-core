package io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.offering.getAllByGroupCode;

import io.github.ctorressoftware.academic.enrollment.courseoffering.domain.model.CourseOffering;

import java.util.List;

public record GetCourseOfferingsByGroupCodeResult(List<CourseOffering> courseOfferings) {}
