package io.github.ctorressoftware.academic.enrollment.account.application.port.in;

public interface CreateAccountUseCase {
    CreateAccountResult create(CreateAccountCommand command);
}
