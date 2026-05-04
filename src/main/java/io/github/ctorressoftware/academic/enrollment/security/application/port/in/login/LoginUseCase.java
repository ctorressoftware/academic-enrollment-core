package io.github.ctorressoftware.academic.enrollment.security.application.port.in.login;

public interface LoginUseCase {
    LoginResult login(LoginCommand command);
}
