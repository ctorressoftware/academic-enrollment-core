package io.github.ctorressoftware.academic.enrollment.enrollment.application.service;

import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.state.getall.GetAllEnrollmentStatesResult;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.state.getall.GetAllEnrollmentStatesUseCase;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.out.EnrollmentStateRepository;
import io.github.ctorressoftware.academic.enrollment.enrollment.domain.model.EnrollmentState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllEnrollmentStatesService implements GetAllEnrollmentStatesUseCase {

    private final EnrollmentStateRepository repository;

    public GetAllEnrollmentStatesService(EnrollmentStateRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetAllEnrollmentStatesResult getAll() {
        List<EnrollmentState> states = repository.getAll();
        return new GetAllEnrollmentStatesResult(states);
    }
}
