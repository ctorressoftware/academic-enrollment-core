package io.github.ctorressoftware.academic.enrollment.security.application.port.in.register;

public interface RegisterUserUseCase {
    RegisterUserResult register(RegisterUserCommand command);
}
