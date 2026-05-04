package io.github.ctorressoftware.academic.enrollment.security.infrastructure.web.response;

import io.github.ctorressoftware.academic.enrollment.security.application.port.in.register.RegisterUserResult;

import java.util.UUID;

public record RegisterResponse(UUID userId, UUID personId, String username, String accessToken) {
    public static RegisterResponse from(RegisterUserResult result) {
        return new RegisterResponse(
                result.userId(),
                result.personId(),
                result.username(),
                result.accessToken()
        );
    }

}
