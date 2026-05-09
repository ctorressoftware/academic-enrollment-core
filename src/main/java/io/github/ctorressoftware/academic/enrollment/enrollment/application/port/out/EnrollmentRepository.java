package io.github.ctorressoftware.academic.enrollment.enrollment.application.port.out;

import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.Enrollment;

import java.util.List;
import java.util.UUID;

public interface EnrollmentRepository {
    Enrollment save(Enrollment enrollment);
    List<Enrollment> getAllByStudentId(UUID studentId);
}
