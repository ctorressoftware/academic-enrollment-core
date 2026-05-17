package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.getallbystudentid;

public interface GetEnrollmentsByStudentIdUseCase {
    GetEnrollmentsByStudentIdResult getAllByStudentId(
            GetEnrollmentsByStudentIdCommand command);
}
