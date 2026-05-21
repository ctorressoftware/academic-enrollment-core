package io.github.ctorressoftware.academic.enrollment.subject.domain.model;

import io.github.ctorressoftware.academic.enrollment.subject.domain.exception.PrerequisiteCircularDependencyException;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Prerequisite {
    private final UUID id;
    private final UUID subjectId;
    private final UUID prerequisiteSubjectId;
    private final UUID careerId;
    private final String description;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;

    public Prerequisite(
            UUID id,
            UUID subjectId,
            UUID prerequisiteSubjectId,
            UUID careerId,
            String description,
            boolean active,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = Objects.requireNonNull(id, "id is null");
        this.subjectId = Objects.requireNonNull(subjectId, "subjectId is null");
        this.prerequisiteSubjectId = Objects.requireNonNull(prerequisiteSubjectId, "prerequisiteSubjectId is null");
        this.careerId = Objects.requireNonNull(careerId, "careerId is null");
        this.description = Objects.requireNonNull(description, "description is null");
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt is null");
    }

    public static Prerequisite create(
            UUID subjectId,
            UUID prerequisiteSubjectId,
            UUID careerId,
            String description
    ) {

        if (subjectId.equals(prerequisiteSubjectId)) {
            throw new PrerequisiteCircularDependencyException(); // handle
        }

        Instant now = Instant.now();
        return new Prerequisite(
                UUID.randomUUID(),
                subjectId,
                prerequisiteSubjectId,
                careerId,
                description,
                true,
                now,
                now
        );
    }

    public static Prerequisite restore(
            UUID id,
            UUID subjectId,
            UUID prerequisiteSubjectId,
            UUID careerId,
            String description,
            boolean active,
            Instant createdAt,
            Instant updatedAt
    ) {
        return new Prerequisite(
                id,
                subjectId,
                prerequisiteSubjectId,
                careerId,
                description,
                active,
                createdAt,
                updatedAt
        );
    }

    public UUID getId() {
        return id;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public UUID getPrerequisiteSubjectId() {
        return prerequisiteSubjectId;
    }

    public UUID getCareerId() {
        return careerId;
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
