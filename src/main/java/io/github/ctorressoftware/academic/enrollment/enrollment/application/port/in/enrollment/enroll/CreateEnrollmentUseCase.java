package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enroll;

public interface CreateEnrollmentUseCase {
    CreateEnrollmentResult enroll(CreateEnrollmentCommand command);
}
