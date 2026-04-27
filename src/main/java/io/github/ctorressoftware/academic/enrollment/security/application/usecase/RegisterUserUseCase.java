package io.github.ctorressoftware.academic.enrollment.security.application.usecase;

import io.github.ctorressoftware.academic.enrollment.security.application.command.RegisterUserCommand;
import io.github.ctorressoftware.academic.enrollment.security.application.result.RegisterUserResult;

public interface RegisterUserUseCase {
    RegisterUserResult register(RegisterUserCommand command);
}
