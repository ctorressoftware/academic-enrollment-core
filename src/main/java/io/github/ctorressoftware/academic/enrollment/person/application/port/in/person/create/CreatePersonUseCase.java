package io.github.ctorressoftware.academic.enrollment.person.application.port.in.person.create;

public interface CreatePersonUseCase {
    CreatePersonResult create(CreatePersonCommand command);
}
