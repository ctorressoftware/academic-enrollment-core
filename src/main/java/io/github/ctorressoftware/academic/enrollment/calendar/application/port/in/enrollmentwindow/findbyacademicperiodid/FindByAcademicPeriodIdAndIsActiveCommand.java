package io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.findbyacademicperiodid;

import java.util.UUID;

public record FindByAcademicPeriodIdAndIsActiveCommand(UUID academicPeriodId) {}
