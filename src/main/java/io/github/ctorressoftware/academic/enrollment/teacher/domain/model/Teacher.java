package io.github.ctorressoftware.academic.enrollment.teacher.domain.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Teacher {
    private final UUID id;
    private final UUID personId;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;

    private Teacher(
            UUID id,
            UUID personId,
            boolean active,
            Instant createdAt,
            Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "id is null");
        this.personId = Objects.requireNonNull(personId, "personId is null");
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt is null");
    }

    public static Teacher create(UUID personId) {
        final var now = Instant.now();
        return new Teacher(
                UUID.randomUUID(),
                personId,
                true,
                now,
                now
        );
    }

    public static Teacher restore(
            UUID id,
            UUID personId,
            boolean active,
            Instant createdAt,
            Instant updatedAt
    ) {
        return new Teacher(
                id,
                personId,
                active,
                createdAt,
                updatedAt
        );
    }

    public UUID getId() {
        return id;
    }

    public UUID getPersonId() {
        return personId;
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
