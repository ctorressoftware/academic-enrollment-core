package io.github.ctorressoftware.academic.enrollment.enrollment.application.service;

import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enroll.CreateEnrollmentCommand;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enroll.CreateEnrollmentResult;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enroll.CreateEnrollmentUseCase;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.out.EnrollmentRepository;
import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.Enrollment;
import org.springframework.stereotype.Service;

@Service
public class CreateEnrollmentService implements CreateEnrollmentUseCase {

    private final EnrollmentRepository repository;

    public CreateEnrollmentService(EnrollmentRepository repository) {
        this.repository = repository;
    }

    // TODO: implement RabbitMQ to enroll service
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
