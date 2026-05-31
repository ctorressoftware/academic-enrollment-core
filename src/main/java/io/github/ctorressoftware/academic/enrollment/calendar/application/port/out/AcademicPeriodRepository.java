package io.github.ctorressoftware.academic.enrollment.calendar.application.port.out;

import io.github.ctorressoftware.academic.enrollment.calendar.domain.model.AcademicPeriod;

import java.util.Optional;
import java.util.UUID;

public interface AcademicPeriodRepository {
    AcademicPeriod save(AcademicPeriod academicPeriod);
    Optional<AcademicPeriod> findById(UUID academicPeriodId);
    Optional<AcademicPeriod> findActiveByQuarterAndYear(
            String quarter,
            short year
    );
}
