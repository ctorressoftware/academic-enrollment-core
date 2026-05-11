package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.web.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateEnrollmentRequest(
        @NotNull(message = "studentId cannot be null")
        UUID studentId,

        @NotNull(message = "courseOfferingId cannot be null")
        UUID courseOfferingId,

        @Min(value = 1, message = "enrollmentStateId only can be a value higher than zero")
        short enrollmentStateId
) {}
