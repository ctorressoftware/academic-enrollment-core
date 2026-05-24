package io.github.ctorressoftware.academic.enrollment.course.application.port.in.offering.create;

import java.util.UUID;

public record CreateCourseOfferingCommand(
        String groupCode,
        UUID academicPeriodId,
        UUID subjectId,
        UUID teacherId,
        short courseStateId,
        short quotas
) {}
