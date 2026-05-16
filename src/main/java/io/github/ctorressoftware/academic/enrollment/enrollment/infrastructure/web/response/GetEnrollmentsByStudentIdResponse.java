package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.web.response;

import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.Enrollment;

import java.util.List;

public record GetEnrollmentsByStudentIdResponse(List<Enrollment> enrollments) {}
