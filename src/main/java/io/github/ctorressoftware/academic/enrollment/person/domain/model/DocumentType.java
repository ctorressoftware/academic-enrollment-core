package io.github.ctorressoftware.academic.enrollment.person.domain.model;

import java.time.Instant;

public class DocumentType {
    private final short id;
    private final String code;
    private final String description;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;

    private DocumentType(
            short id,
            String code,
            String description,
            boolean active,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static DocumentType create(short id, String code, String description) {
        Instant now = Instant.now();
        return new DocumentType(
                id,
                code,
                description,
                true,
                now,
                now
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
