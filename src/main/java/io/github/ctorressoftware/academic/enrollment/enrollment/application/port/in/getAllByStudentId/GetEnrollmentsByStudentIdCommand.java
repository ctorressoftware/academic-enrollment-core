package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.getAllByStudentId;

import java.util.UUID;

public record GetEnrollmentsByStudentIdCommand(
        UUID studentId
) {}
