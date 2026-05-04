package io.github.ctorressoftware.academic.enrollment.security.domain.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class User {
    private final UUID id;
    private final UUID personId;
    private final Username username;
    private final PasswordHash passwordHash;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;

    private User(
            UUID id,
            UUID personId,
            Username username,
            PasswordHash passwordHash,
            boolean active,
            Instant createdAt,
            Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "id is null");
        this.personId = Objects.requireNonNull(personId, "personId is null");
        this.username = Objects.requireNonNull(username, "username is null");
        this.passwordHash = Objects.requireNonNull(passwordHash, "passwordHash is null");
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt is null");
    }

    public static User create(UUID personId, Username username, PasswordHash passwordHash) {
        final var now = Instant.now();
        return new User(
                UUID.randomUUID(),
                personId,
                username,
                passwordHash,
                true,
                now,
                now
        );
    }

    public static User restore(
            UUID id,
            UUID personId,
            Username username,
            PasswordHash passwordHash,
            boolean active,
            Instant createdAt,
            Instant updatedAt) {
        return new User(
                id,
                personId,
                username,
                passwordHash,
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

    public Username getUsername() {
        return username;
    }

    public PasswordHash getPasswordHash() {
        return passwordHash;
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