package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.messaging.rabbitmq.partition;

import java.util.Objects;
import java.util.UUID;

public final class HashEnrollmentPartitioner
        implements EnrollmentPartitioner {

    private final int partitions;

    public HashEnrollmentPartitioner(int partitions) {
        if (partitions <= 0)
            throw new IllegalArgumentException("partitions must be greater than zero");

        this.partitions = partitions;
    }

    @Override
    public int partition(UUID courseOfferingId) {
        Objects.requireNonNull(
                courseOfferingId, "courseOfferingId cannot be null");

        return Math.floorMod(courseOfferingId.hashCode(), partitions);
    }
}