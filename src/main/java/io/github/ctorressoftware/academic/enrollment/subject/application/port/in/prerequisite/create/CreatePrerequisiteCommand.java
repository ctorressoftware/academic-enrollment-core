package io.github.ctorressoftware.academic.enrollment.subject.application.port.in.prerequisite.create;

import java.util.UUID;

public record CreatePrerequisiteCommand(
        UUID subjectId,
        UUID prerequisiteSubjectId,
        UUID careerId,
        String description
) {}
