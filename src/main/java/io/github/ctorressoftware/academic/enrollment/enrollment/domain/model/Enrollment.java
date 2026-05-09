package io.github.ctorressoftware.academic.enrollment.enrollment.domain.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Enrollment {
    private final UUID id;
    private final UUID studentId;
    private final UUID courseOfferingId;
    private final short enrollmentStateId;
    private final Instant createdAt;
    private final Instant updatedAt;

    private Enrollment(
            UUID id,
            UUID studentId,
            UUID courseOfferingId,
            short enrollmentStateId,
            Instant createdAt,
            Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "id is null");
        this.studentId = Objects.requireNonNull(studentId, "studentId is null");
        this.courseOfferingId = Objects.requireNonNull(courseOfferingId, "courseOfferingId is null");
        this.enrollmentStateId = enrollmentStateId;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt is null");
    }

    public static Enrollment create(
            UUID studentId,
            UUID courseOfferingId,
            short enrollmentStateId
    ) {
        Instant now = Instant.now();
        return new Enrollment(
                UUID.randomUUID(),
                studentId,
                courseOfferingId,
                enrollmentStateId,
                now,
                now
        );
    }

    public static Enrollment restore(
            UUID id,
            UUID studentId,
            UUID courseOfferingId,
            short enrollmentStateId,
            Instant createdAt,
            Instant updatedAt
    ) {
        return new Enrollment(
                id,
                studentId,
                courseOfferingId,
                enrollmentStateId,
                createdAt,
                updatedAt
        );
    }

    public UUID getId() {
        return id;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public UUID getCourseOfferingId() {
        return courseOfferingId;
    }

    public short getEnrollmentStateId() {
        return enrollmentStateId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
