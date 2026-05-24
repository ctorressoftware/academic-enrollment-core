package io.github.ctorressoftware.academic.enrollment.security.domain.model;

import java.time.Instant;
import java.util.Objects;

/* TODO: create ports and a controller for admin role
   maybe it's a good idea to separate this in its own slice.
*/
public class Role {
    private final short id;
    private final String code;
    private final String description;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;

    private Role(
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

    public static Role create(short id, String code, String description) {
        Instant now = Instant.now();
        return new Role(
                id,
                code,
                description,
                true,
                now,
                now
        );
    }

    public static Role restore(
            short id,
            String code,
            String description,
            boolean active,
            Instant createdAt,
            Instant updatedAt
    ) {
        return new Role(
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
