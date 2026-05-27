package io.github.ctorressoftware.academic.enrollment.calendar.application.port.out;

import io.github.ctorressoftware.academic.enrollment.calendar.domain.model.AcademicPeriod;

import java.util.Optional;

public interface AcademicPeriodRepository {
    AcademicPeriod save(AcademicPeriod academicPeriod);
    Optional<AcademicPeriod> findByQuarterAndYearAndIsActive(
            String quarter,
            short year,
            boolean active
    );
}
