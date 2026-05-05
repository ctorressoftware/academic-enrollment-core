package io.github.ctorressoftware.academic.enrollment.teacher.application.port.in.create;

public interface CreateTeacherUseCase {
    CreateTeacherResult create(CreateTeacherCommand command);
}
