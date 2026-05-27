package io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.create;

import java.time.Instant;
import java.util.UUID;

public record CreateEnrollmentWindowCommand(
        UUID academicPeriodId,
        String type,
        Instant opensAt,
        Instant closesAt
) {}
