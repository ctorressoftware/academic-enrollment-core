package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.out;

import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.EnrollmentState;

import java.util.List;

public interface EnrollmentStateRepository {
    EnrollmentState save(EnrollmentState state);
    List<EnrollmentState> getAll();
}
