package io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.web.request;

public record CreateAcademicPeriodRequest(
        String quarter,
        short year
) {}
