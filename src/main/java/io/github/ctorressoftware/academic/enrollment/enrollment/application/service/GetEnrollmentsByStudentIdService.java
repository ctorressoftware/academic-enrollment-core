package io.github.ctorressoftware.academic.enrollment.enrollment.application.service;

import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.getAllByStudentId.GetEnrollmentsByStudentIdCommand;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.getAllByStudentId.GetEnrollmentsByStudentIdResult;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.getAllByStudentId.GetEnrollmentsByStudentIdUseCase;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.out.EnrollmentRepository;
import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.Enrollment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEnrollmentsByStudentIdService
        implements GetEnrollmentsByStudentIdUseCase {

    private final EnrollmentRepository repository;

    public GetEnrollmentsByStudentIdService(EnrollmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetEnrollmentsByStudentIdResult getAllByStudentId(GetEnrollmentsByStudentIdCommand command) {

        List<Enrollment> enrollmentEntities =
                repository.getAllByStudentId(command.studentId());

        return new GetEnrollmentsByStudentIdResult(enrollmentEntities);
    }
}
