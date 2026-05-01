package io.github.ctorressoftware.academic.enrollment.person.domain.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

// TODO: check if Gender should be a value object
public class Person {
    private final UUID id;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String secondLastName;
    private final Document document;
    private final int genderId;
    private final Email email; //
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;

    private Person(
            UUID id,
            String firstName,
            String middleName,
            String lastName,
            String secondLastName,
            Document document,
            int genderId,
            Email email,
            boolean active,
            Instant createdAt,
            Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "id is null");
        this.firstName = validateName(firstName, "firstName", true);
        this.middleName = validateName(middleName, "middleName", false);
        this.lastName = validateName(lastName, "lastName", true);
        this.secondLastName = validateName(secondLastName, "secondLastName", true);
        this.document = Objects.requireNonNull(document, "document is null");
        this.genderId = Objects.requireNonNull(genderId, "genderId is null");
        this.email = Objects.requireNonNull(email, "email is null");
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt is null");
    }

    public static Person create(
            String firstName,
            String middleName,
            String lastName,
            String secondLastName,
            Document document,
            int genderId,
            Email email
    ) {
        Instant now = Instant.now();
        return new Person(
                UUID.randomUUID(),
                firstName,
                middleName,
                lastName,
                secondLastName,
                document,
                genderId,
                email,
                true,
                now,
                now
        );
    }

    public static Person restore(
            UUID id,
            String firstName,
            String middleName,
            String lastName,
            String secondLastName,
            Document document,
            int genderId,
            Email email,
            boolean active,
            Instant createdAt,
            Instant updatedAt
    ) {
        return new Person(
                id,
                firstName,
                middleName,
                lastName,
                secondLastName,
                document,
                genderId,
                email,
                active,
                createdAt,
                updatedAt
        );
    }

    private String validateName(String value, String fieldName, boolean required) {
        if (value == null) {
            if (required) {
                throw new IllegalArgumentException(fieldName + " is required");
            }

            return null;
        }

        String normalized = value.trim();

        if (normalized.isBlank()) {
            if (required) {
                throw new IllegalArgumentException(fieldName + " is required");
            }

            throw new IllegalArgumentException(fieldName + " cannot be blank");
        }

        return normalized;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public Document getDocument() {
        return document;
    }

    public int getGenderId() {
        return genderId;
    }

    public Email getEmail() {
        return email;
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
