package io.github.ctorressoftware.academic.enrollment.enrollment.domain.event;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class EnrollmentRequestedEvent {
    private final UUID requestId;
    private final UUID studentId;
    private final UUID courseOfferingId;
    private final Instant requestedAt;

    private EnrollmentRequestedEvent(
            UUID requestId,
            UUID studentId,
            UUID courseOfferingId,
            Instant requestedAt
    ) {
        this.requestId = Objects.requireNonNull(requestId, "requestId cannot be null");
        this.studentId = Objects.requireNonNull(studentId, "studentId cannot be null");
        this.courseOfferingId = Objects.requireNonNull(courseOfferingId, "courseOfferingId cannot be null");
        this.requestedAt = Objects.requireNonNull(requestedAt, "requestedAt cannot be null");
    }

    public static EnrollmentRequestedEvent create(
            UUID studentId,
            UUID courseOfferingId) {
        return new EnrollmentRequestedEvent(
                UUID.randomUUID(),
                studentId,
                courseOfferingId,
                Instant.now()
        );
    }

    public UUID getRequestId() {
        return requestId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public UUID getCourseOfferingId() {
        return courseOfferingId;
    }

    public Instant getRequestedAt() {
        return requestedAt;
    }
}
