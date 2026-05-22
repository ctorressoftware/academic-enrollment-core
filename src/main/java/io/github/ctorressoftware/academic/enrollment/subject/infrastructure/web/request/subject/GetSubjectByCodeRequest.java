package io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.request.subject;

import jakarta.validation.constraints.NotBlank;

public record GetSubjectByCodeRequest(
        @NotBlank(message = "code cannot be blank")
        String code
) {}
