package io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.create;

public interface CreateSubjectUseCase {
    CreateSubjectResult create(CreateSubjectCommand command);
}
