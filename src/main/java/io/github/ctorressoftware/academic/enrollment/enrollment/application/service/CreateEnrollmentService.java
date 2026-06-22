package io.github.ctorressoftware.academic.enrollment.enrollment.application.service;

import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enrollment.enroll.CreateEnrollmentCommand;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enrollment.enroll.CreateEnrollmentResult;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enrollment.enroll.CreateEnrollmentUseCase;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.out.EnrollmentRepository;
import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.Enrollment;
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
public class CreateEnrollmentService implements CreateEnrollmentUseCase {

    private final EnrollmentRepository repository;

    public CreateEnrollmentService(EnrollmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateEnrollmentResult enroll(CreateEnrollmentCommand command) {

        Enrollment enrollment = Enrollment.create(
                command.studentId(),
                command.courseOfferingId(),
                command.enrollmentStateId()
        );

        Enrollment saved = repository.save(enrollment);

        return new CreateEnrollmentResult(saved);
    }
}
