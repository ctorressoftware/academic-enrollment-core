package io.github.ctorressoftware.academic.enrollment.student.application.port.in.create;

public interface CreateStudentUseCase {
    CreateStudentResult create(CreateStudentCommand command);
}
