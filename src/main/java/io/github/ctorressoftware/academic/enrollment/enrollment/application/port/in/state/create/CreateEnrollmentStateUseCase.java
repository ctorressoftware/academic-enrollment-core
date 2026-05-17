package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.state.create;

public interface CreateEnrollmentStateUseCase {
    CreateEnrollmentStateResult create(CreateEnrollmentStateCommand command);
}
