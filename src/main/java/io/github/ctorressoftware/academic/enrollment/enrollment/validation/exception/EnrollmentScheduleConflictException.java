package io.github.ctorressoftware.academic.enrollment.enrollment.validation.exception;

import java.util.UUID;

public class EnrollmentScheduleConflictException extends RuntimeException {

    public EnrollmentScheduleConflictException(UUID studentId, UUID courseOfferingId) {
        super("Student with ID %s cannot enroll in course offering %s "
                .formatted(studentId, courseOfferingId)
                + "because its schedule conflicts with an existing enrollment.");
    }
}