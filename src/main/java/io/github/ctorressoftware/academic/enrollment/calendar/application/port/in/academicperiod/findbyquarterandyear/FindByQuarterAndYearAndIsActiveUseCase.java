package io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.academicperiod.findbyquarterandyear;

public interface FindByQuarterAndYearAndIsActiveUseCase {
    FindByQuarterAndYearAndIsActiveResult find(
            FindByQuarterAndYearAndIsActiveCommand command);
}
