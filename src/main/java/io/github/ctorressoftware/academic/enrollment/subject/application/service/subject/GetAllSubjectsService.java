package io.github.ctorressoftware.academic.enrollment.subject.application.service;

import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.getAll.GetAllSubjectsCommand;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.getAll.GetAllSubjectsResult;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.getAll.GetAllSubjectsUseCase;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.out.SubjectRepository;
import io.github.ctorressoftware.academic.enrollment.subject.domain.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GetAllSubjectsService implements GetAllSubjectsUseCase {

    private final SubjectRepository repository;

    public GetAllSubjectsService(SubjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetAllSubjectsResult getAll(GetAllSubjectsCommand command) {
        Objects.requireNonNull(command, "command is null");

        List<Subject> subjects = repository
                .findAll(command.page(), command.pageSize());

        return new GetAllSubjectsResult(subjects);
    }
}
