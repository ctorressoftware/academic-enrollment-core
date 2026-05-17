package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.getallbystudentid;

import java.util.UUID;

public record GetEnrollmentsByStudentIdCommand(
        UUID studentId
) {}
