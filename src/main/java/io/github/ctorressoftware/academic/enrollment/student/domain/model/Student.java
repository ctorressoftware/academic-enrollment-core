package io.github.ctorressoftware.academic.enrollment.student.domain.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Student {
    private final UUID id;
    private final UUID personId;
    private final UUID careerId;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;

    private Student(
            UUID id,
            UUID personId,
            UUID careerId,
            boolean active,
            Instant createdAt,
            Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "id is null");
        this.personId = Objects.requireNonNull(personId, "personId is null");
        this.careerId = Objects.requireNonNull(careerId, "careerId is null");
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt is null");
    }

    public static Student create(UUID personId, UUID careerId) {
        final var now = Instant.now();
        return new Student(
                UUID.randomUUID(),
                personId,
                careerId,
                true,
                now,
                now
        );
    }

    public static Student restore(
            UUID id,
            UUID personId,
            UUID careerId,
            boolean active,
            Instant createdAt,
            Instant updatedAt
    ) {
        return new Student(
                id,
                personId,
                careerId,
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

    public UUID getCareerId() {
        return careerId;
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
