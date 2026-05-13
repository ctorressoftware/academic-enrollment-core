package io.github.ctorressoftware.academic.enrollment.person.application.port.in.gender.create;

public interface CreateGenderUseCase {
    CreateGenderResult save(CreateGenderCommand command);
}
