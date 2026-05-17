package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enrollment.getbystudentid;

public interface GetEnrollmentsByStudentIdUseCase {
    GetEnrollmentsByStudentIdResult getAllByStudentId(
            GetEnrollmentsByStudentIdCommand command);
}
