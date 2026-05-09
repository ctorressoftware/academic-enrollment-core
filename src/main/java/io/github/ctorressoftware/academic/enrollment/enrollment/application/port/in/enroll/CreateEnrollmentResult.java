package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enroll;

import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.Enrollment;

public record CreateEnrollmentResult(
        Enrollment enrollment
) {}
