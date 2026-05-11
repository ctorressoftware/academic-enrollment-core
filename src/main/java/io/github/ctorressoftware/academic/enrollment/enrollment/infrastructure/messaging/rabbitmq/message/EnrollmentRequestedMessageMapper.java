package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.messaging.rabbitmq.message;

import io.github.ctorressoftware.academic.enrollment.enrollment.domain.event.EnrollmentRequestedEvent;

public final class EnrollmentRequestedMessageMapper {

    private EnrollmentRequestedMessageMapper() {
    }

    public static EnrollmentRequestedV1Message toMessage(EnrollmentRequestedEvent event) {
        return new EnrollmentRequestedV1Message(
                event.getRequestId(),
                event.getStudentId(),
                event.getCourseOfferingId(),
                event.getRequestedAt()
        );
    }
}
