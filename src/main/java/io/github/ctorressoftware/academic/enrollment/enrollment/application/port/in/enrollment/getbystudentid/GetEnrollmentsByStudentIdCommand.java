package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enrollment.getbystudentid;

import java.util.UUID;

public record GetEnrollmentsByStudentIdCommand(
        UUID studentId
) {}
