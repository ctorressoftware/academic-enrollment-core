package io.github.ctorressoftware.academic.enrollment.security.domain.model;

import java.time.Instant;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class User {
    private static final Pattern USERNAME_PATTERN =
            Pattern.compile("^[a-z][a-z0-9]{2,}$");
    private final UUID id;
    private final UUID personId;
    private final String username;
    private final String passwordHash;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;

    private User(
            UUID id,
            UUID personId,
            String username,
            String passwordHash,
            boolean active,
            Instant createdAt,
            Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "id is null");
        this.personId = Objects.requireNonNull(personId, "personId is null");
        this.username = validateUsername(username);
        this.passwordHash = validatePasswordHash(passwordHash);
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt is null");
    }

    public static User create(UUID personId, String username, String passwordHash) {
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

    public UUID getId() {
        return id;
    }

    public UUID getPersonId() {
        return personId;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
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

    private static String validateUsername(String username) {
        Objects.requireNonNull(username, "username is null");
        String normalizedUsername = username.trim().toLowerCase(Locale.ROOT);

        if (normalizedUsername.isBlank()) {
            throw new IllegalArgumentException("username cannot be blank");
        }

        if (!USERNAME_PATTERN.matcher(normalizedUsername).matches()) {
            throw new IllegalArgumentException("invalid username format");
        }

        return normalizedUsername;
    }

    private static String validatePasswordHash(String passwordHash) {
        Objects.requireNonNull(passwordHash, "passwordHash is null");

        if (passwordHash.isBlank()) {
            throw new IllegalArgumentException("passwordHash cannot be blank");
        }

        if (passwordHash.chars().anyMatch(Character::isWhitespace)) {
            throw new IllegalArgumentException("passwordHash cannot contain whitespace");
        }

        return passwordHash;
    }
}