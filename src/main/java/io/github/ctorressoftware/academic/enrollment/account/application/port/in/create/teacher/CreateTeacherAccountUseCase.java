package io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.teacher;

public interface CreateTeacherAccountUseCase {
    CreateTeacherAccountResult create(CreateTeacherAccountCommand command);
}
