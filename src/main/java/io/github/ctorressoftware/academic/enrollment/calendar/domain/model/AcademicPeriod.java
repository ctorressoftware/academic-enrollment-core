package io.github.ctorressoftware.academic.enrollment.calendar.domain.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class AcademicPeriod {
    private final UUID id;
    private final String quarter;
    private final short year;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;

    private AcademicPeriod(
            UUID id,
            String quarter,
            short year,
            boolean active,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.quarter = Objects.requireNonNull(quarter, "quarter cannot be null");
        this.year = year;
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt cannot be null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt cannot be null");
    }

    public static AcademicPeriod create(String quarter, short year) {
        Instant now = Instant.now();
        return new AcademicPeriod(
                UUID.randomUUID(),
                quarter,
                year,
                true,
                now,
                now
        );
    }

    public static AcademicPeriod restore(
            UUID id,
            String quarter,
            short year,
            boolean active,
            Instant createdAt,
            Instant updatedAt) {

        return new AcademicPeriod(
                id,
                quarter,
                year,
                active,
                createdAt,
                updatedAt
        );
    }

    public UUID getId() {
        return id;
    }

    public String getQuarter() {
        return quarter;
    }

    public short getYear() {
        return year;
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