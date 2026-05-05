package io.github.ctorressoftware.academic.enrollment.student.application.port.in.create;

import java.util.UUID;

public record CreateStudentCommand(
        UUID personId,
        UUID careerId
) {}
