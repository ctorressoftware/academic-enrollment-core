package io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.request.prerequisite;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreatePrerequisiteRequest(
        @NotNull(message = "subjectId cannot be null")
        UUID subjectId,

        @NotNull(message = "prerequisiteSubjectId cannot be null")
        UUID prerequisiteSubjectId,

        @NotNull(message = "careerId cannot be null")
        UUID careerId,

        @NotBlank(message = "description cannot be blank")
        String description
) {}
