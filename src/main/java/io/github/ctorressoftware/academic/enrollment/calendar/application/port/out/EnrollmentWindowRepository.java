package io.github.ctorressoftware.academic.enrollment.calendar.application.port.out;

import io.github.ctorressoftware.academic.enrollment.calendar.domain.model.EnrollmentWindow;

import java.util.Optional;
import java.util.UUID;

public interface EnrollmentWindowRepository {
    EnrollmentWindow save(EnrollmentWindow enrollmentWindow);
    Optional<EnrollmentWindow> findActiveByAcademicPeriodId(UUID academicPeriodId);
}
