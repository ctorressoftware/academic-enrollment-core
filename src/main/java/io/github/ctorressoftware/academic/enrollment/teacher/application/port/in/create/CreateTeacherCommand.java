package io.github.ctorressoftware.academic.enrollment.teacher.application.port.in.create;

import java.util.UUID;

public record CreateTeacherCommand(
        UUID personId,
        UUID careerId
) {}
