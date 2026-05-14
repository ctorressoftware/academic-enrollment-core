package io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.web.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateGenderRequest(
        @Min(value = 1, message = "id has to be higher than zero")
        short id,

        @NotBlank(message = "code cannot be blank")
        String code,

        @NotBlank(message = "description cannot be blank")
        String description
) {}
