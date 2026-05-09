package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.getAllByStudentId;

import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.Enrollment;

import java.util.List;

public record GetEnrollmentsByStudentIdResult(List<Enrollment> enrollments) {}
