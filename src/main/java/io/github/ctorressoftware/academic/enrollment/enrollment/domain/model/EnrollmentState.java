package io.github.ctorressoftware.academic.enrollment.enrollment.domain.model;

import java.time.Instant;
import java.util.Objects;

public class EnrollmentState {
    private final Short id;
    private final String code;
    private final String description;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;

    private EnrollmentState(
            short id,
            String code,
            String description,
            boolean active,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = id;
        this.code = Objects.requireNonNull(code, "code cannot be null");
        this.description = Objects.requireNonNull(description, "description cannot be null");
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt cannot be null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt cannot be null");
    }

    public static EnrollmentState create(short id, String code, String description) {

        if (id <= 0) {
            throw new IllegalArgumentException("id must be higher than zero");
        }

        Instant now = Instant.now();
        return new EnrollmentState(
                id,
                code,
                description,
                true,
                now,
                now
        );
    }

    public static EnrollmentState restore(
            short id,
            String code,
            String description,
            boolean active,
            Instant createdAt,
            Instant updatedAt
    ) {
        return new EnrollmentState(
                id,
                code,
                description,
                active,
                createdAt,
                updatedAt
        );
    }

    public short getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
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
