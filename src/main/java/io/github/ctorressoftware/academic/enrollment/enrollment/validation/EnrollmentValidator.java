package io.github.ctorressoftware.academic.enrollment.enrollment.validation;

import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.out.EnrollmentRepository;
import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.Enrollment;
import io.github.ctorressoftware.academic.enrollment.enrollment.validation.exception.EnrollmentScheduleConflictException;
import org.springframework.stereotype.Service;

/*
 * TODO: Before enrolling the student, validate the enrollment policy:
 *  - The course offering's schedule does not conflict with the student's already enrolled courses.
 *  - The student has completed all required prerequisites.
 *  - The course offering has available capacity.
 *  - The student is not already enrolled in this course offering.
 *  - The course offering is AVAILABLE according to its course state.
 *  - The student does not exceed the credit limit by adding this course.
 */

@Service
public class EnrollmentValidator {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentValidator(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public void validate(Enrollment newEnrollment) {
        if (!checkIfAcademicPeriodIsAvailable(newEnrollment)) {
            throw new EnrollmentScheduleConflictException(
                    newEnrollment.getStudentId(),
                    newEnrollment.getCourseOfferingId()
            );
        }


    }

    private boolean checkIfAcademicPeriodIsAvailable(Enrollment enrollment) {
        return enrollmentRepository.existsEnrollmentScheduleConflict(
                enrollment.getStudentId(),
                enrollment.getCourseOfferingId()
        );
    }

}
