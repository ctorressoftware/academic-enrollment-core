package io.github.ctorressoftware.academic.enrollment.calendar.domain.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class EnrollmentWindow {
    private final UUID id;
    private final UUID academicPeriodId;
    private final String type;
    private final Instant opensAt;
    private final Instant closesAt;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;

    private EnrollmentWindow(
            UUID id,
            UUID academicPeriodId,
            String type,
            Instant opensAt,
            Instant closesAt,
            boolean active,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.academicPeriodId = Objects.requireNonNull(academicPeriodId, "academicPeriodId cannot be null");
        this.type = Objects.requireNonNull(type, "type cannot be null");
        this.opensAt = Objects.requireNonNull(opensAt, "opensAt cannot be null");
        this.closesAt = Objects.requireNonNull(closesAt, "closesAt cannot be null");
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt cannot be null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt cannot be null");
    }

    public static EnrollmentWindow create(
            UUID academicPeriodId,
            String type,
            Instant opensAt,
            Instant closesAt
    ) {
        Instant now = Instant.now();

        return new EnrollmentWindow(
                UUID.randomUUID(),
                academicPeriodId,
                type,
                opensAt,
                closesAt,
                true,
                now,
                now
        );
    }

    public static EnrollmentWindow restore(
            UUID id,
            UUID academicPeriodId,
            String type,
            Instant opensAt,
            Instant closesAt,
            boolean active,
            Instant createdAt,
            Instant updatedAt
    ) {
        return new EnrollmentWindow(
                id,
                academicPeriodId,
                type,
                opensAt,
                closesAt,
                active,
                createdAt,
                updatedAt
        );
    }

    public UUID getId() {
        return id;
    }

    public UUID getAcademicPeriodId() {
        return academicPeriodId;
    }

    public String getType() {
        return type;
    }

    public Instant getOpensAt() {
        return opensAt;
    }

    public Instant getClosesAt() {
        return closesAt;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
