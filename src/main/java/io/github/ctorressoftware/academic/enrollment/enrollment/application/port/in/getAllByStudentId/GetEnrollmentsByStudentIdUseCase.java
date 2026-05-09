package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.getAllByStudentId;

public interface GetEnrollmentsByStudentIdUseCase {
    GetEnrollmentsByStudentIdResult getAllByStudentId(
            GetEnrollmentsByStudentIdCommand command);
}
