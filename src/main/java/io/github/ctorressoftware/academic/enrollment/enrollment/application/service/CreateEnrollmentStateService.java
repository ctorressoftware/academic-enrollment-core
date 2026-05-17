package io.github.ctorressoftware.academic.enrollment.enrollment.application.service;

import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.state.create.CreateEnrollmentStateCommand;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.state.create.CreateEnrollmentStateResult;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.state.create.CreateEnrollmentStateUseCase;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.out.EnrollmentStateRepository;
import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.EnrollmentState;
import org.springframework.stereotype.Service;

@Service
public class CreateEnrollmentStateService implements CreateEnrollmentStateUseCase {

    private final EnrollmentStateRepository repository;

    public CreateEnrollmentStateService(EnrollmentStateRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateEnrollmentStateResult create(CreateEnrollmentStateCommand command) {

        EnrollmentState state = EnrollmentState.create(
                command.id(),
                command.code(),
                command.description()
        );

        EnrollmentState saved = repository.save(state);

        return new CreateEnrollmentStateResult(saved);
    }
}
