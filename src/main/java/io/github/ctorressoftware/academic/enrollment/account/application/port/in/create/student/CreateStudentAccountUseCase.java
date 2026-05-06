package io.github.ctorressoftware.academic.enrollment.account.application.port.in.create;

public interface CreateAccountUseCase {
    CreateAccountResult create(CreateAccountCommand command);
}
