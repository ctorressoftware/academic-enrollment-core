package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enroll;

import java.util.UUID;

public record CreateEnrollmentCommand(
        UUID studentId,
        UUID courseOfferingId,
        short enrollmentStateId
) {}
