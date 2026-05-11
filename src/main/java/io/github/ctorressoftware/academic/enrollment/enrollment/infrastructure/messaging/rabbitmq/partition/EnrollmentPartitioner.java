package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.messaging.rabbitmq.partition;

import java.util.UUID;

public interface EnrollmentPartitioner {
    int partition(UUID courseOfferingId);
}
