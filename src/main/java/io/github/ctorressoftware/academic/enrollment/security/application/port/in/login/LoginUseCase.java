package io.github.ctorressoftware.academic.enrollment.security.application.usecase;

import io.github.ctorressoftware.academic.enrollment.security.application.command.LoginCommand;
import io.github.ctorressoftware.academic.enrollment.security.application.result.LoginResult;

public interface LoginUseCase {
    LoginResult login(LoginCommand command);
}
