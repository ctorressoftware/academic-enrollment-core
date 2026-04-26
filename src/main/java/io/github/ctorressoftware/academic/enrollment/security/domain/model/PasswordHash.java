package io.github.ctorressoftware.academic.enrollment.security.domain.model;

public record PasswordHash(String value) {

    public PasswordHash {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("PasswordHash hash must not be blank");
        }

        if (value.chars().anyMatch(Character::isWhitespace)) {
            throw new IllegalArgumentException("PasswordHash cannot contain whitespace");
        }
    }
}