package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.messaging.rabbitmq.message;

import java.time.Instant;
import java.util.UUID;

public record EnrollmentRequestedV1Message(
        UUID requestId,
        UUID studentId,
        UUID courseOfferingId,
        Instant requestedAt
) {}