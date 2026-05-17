package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enrollment.enroll;

public interface CreateEnrollmentUseCase {
    CreateEnrollmentResult enroll(CreateEnrollmentCommand command);
}
