package io.github.ctorressoftware.academic.enrollment.courseoffering.infrastructure.web.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCourseStateRequest(
        @NotNull(message = "id cannot be null")
        @Min(value = 1, message = "id only can be a value higher than zero")
        Short id,

        @NotBlank(message = "code cannot be blank")
        String code,

        @NotBlank(message = "description cannot be blank")
        String description
) {}
