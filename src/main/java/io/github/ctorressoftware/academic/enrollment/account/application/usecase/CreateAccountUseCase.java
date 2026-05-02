package io.github.ctorressoftware.academic.enrollment.account.application.usecase;

import io.github.ctorressoftware.academic.enrollment.account.application.command.CreateAccountCommand;
import io.github.ctorressoftware.academic.enrollment.account.application.result.CreateAccountResult;

public interface CreateAccountUseCase {
    CreateAccountResult create(CreateAccountCommand command);
}
