package io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.request;

import jakarta.validation.constraints.NotBlank;

public record CreateSubjectRequest(
        @NotBlank(message = "code cannot be blank")
        String code,

        @NotBlank(message = "description cannot be blank")
        String description
) {}
