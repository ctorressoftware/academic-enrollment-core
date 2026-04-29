package io.github.ctorressoftware.academic.enrollment.security.infrastructure.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank(message = "Username cannot be blank")
        String username,

        @NotBlank(message = "Password cannot be blank")
        String password
) {}
