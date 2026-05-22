package io.github.ctorressoftware.academic.enrollment.subject.application.service.subject;

import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.create.CreateSubjectCommand;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.create.CreateSubjectResult;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.create.CreateSubjectUseCase;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.out.SubjectRepository;
import io.github.ctorressoftware.academic.enrollment.subject.domain.model.Subject;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CreateSubjectService implements CreateSubjectUseCase {

    private final SubjectRepository repository;

    public CreateSubjectService(SubjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateSubjectResult create(CreateSubjectCommand command) {
        Objects.requireNonNull(command, "command is null");
        Subject subject = Subject.create(command.code(), command.description());
        Subject saved = repository.save(subject);

        return new CreateSubjectResult(saved);
    }
}
