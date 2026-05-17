package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.state.getall;

import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.EnrollmentState;

import java.util.List;

public record GetAllEnrollmentStatesResult(List<EnrollmentState> states) {}
