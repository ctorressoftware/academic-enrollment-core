package io.github.ctorressoftware.academic.enrollment.subject.application.port.in.prerequisite.create;

public interface CreatePrerequisiteUseCase {
    CreatePrerequisiteResult create(CreatePrerequisiteCommand command);
}
