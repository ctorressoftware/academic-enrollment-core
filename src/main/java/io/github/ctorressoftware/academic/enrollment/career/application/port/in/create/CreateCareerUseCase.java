package io.github.ctorressoftware.academic.enrollment.career.application.port.in.create;

public interface CreateCareerUseCase {
    CreateCareerResult create(CreateCareerCommand command);
}
