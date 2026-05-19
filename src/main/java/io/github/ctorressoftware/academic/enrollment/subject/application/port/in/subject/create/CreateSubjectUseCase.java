package io.github.ctorressoftware.academic.enrollment.subject.application.port.in.create;

public interface CreateSubjectUseCase {
    CreateSubjectResult create(CreateSubjectCommand command);
}
