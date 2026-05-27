package io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.findbyacademicperiodid;

public interface FindByAcademicPeriodIdAndIsActiveUseCase {
    FindByAcademicPeriodIdAndIsActiveResult find(
            FindByAcademicPeriodIdAndIsActiveCommand command);
}
