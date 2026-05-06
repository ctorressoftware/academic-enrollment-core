package io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.student;

public interface CreateStudentAccountUseCase {
    CreateStudentAccountResult create(CreateStudentAccountCommand command);
}
