package io.github.ctorressoftware.academic.enrollment.security.infrastructure.web.response;

import io.github.ctorressoftware.academic.enrollment.security.application.port.in.login.LoginResult;

public record LoginResponse(
        String username,
        String accessToken
) {
    public static LoginResponse from(LoginResult result) {
        return new LoginResponse(
                result.username(),
                result.accessToken()
        );
    }
}
