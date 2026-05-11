package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.out;

import io.github.ctorressoftware.academic.enrollment.enrollment.domain.event.EnrollmentRequestedEvent;

public interface EnrollmentRequestedPublisher {
    void publish(EnrollmentRequestedEvent event);
}
