package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.web.response;

import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.EnrollmentState;

import java.util.List;

public record GetAllEnrollmentStatesResponse(List<EnrollmentState> states) {}
