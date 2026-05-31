package io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.web.request;

import java.time.Instant;
import java.util.UUID;

public record CreateEnrollmentWindowRequest(
        UUID academicPeriodId,
        String type,
        Instant opensAt,
        Instant closesAt
) {}
