package io.github.ctorressoftware.academic.enrollment.subject.domain.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Subject {
    private final UUID id;
    private final String code;
    private final String description;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;

    public Subject(
            UUID id,
            String code,
            String description,
            boolean active,
            Instant createdAt,
            Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "id is null");
        this.code = Objects.requireNonNull(code, "code is null");
        this.description = Objects.requireNonNull(description, "description is null");
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt is null");
    }

    public static Subject create(String code, String description) {
        Instant now = Instant.now();
        return new Subject(
                UUID.randomUUID(),
                code,
                description,
                true,
                now,
                now
        );
    }

    public static Subject restore(
            UUID id,
            String code,
            String description,
            boolean active,
            Instant createdAt,
            Instant updatedAt
    ) {
        return new Subject(
                id,
                code,
                description,
                active,
                createdAt,
                updatedAt
        );
    }

    public UUID getId() {
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