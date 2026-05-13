package io.github.ctorressoftware.academic.enrollment.person.application.port.in.create;

public interface CreatePersonUseCase {
    CreatePersonResult create(CreatePersonCommand command);
}
