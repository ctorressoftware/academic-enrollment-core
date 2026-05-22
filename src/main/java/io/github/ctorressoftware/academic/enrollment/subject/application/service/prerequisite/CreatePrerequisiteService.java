package io.github.ctorressoftware.academic.enrollment.subject.application.service.prerequisite;

import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.prerequisite.create.CreatePrerequisiteCommand;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.prerequisite.create.CreatePrerequisiteResult;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.prerequisite.create.CreatePrerequisiteUseCase;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.out.PrerequisiteRepository;
import io.github.ctorressoftware.academic.enrollment.subject.domain.model.Prerequisite;
import org.springframework.stereotype.Service;

@Service
public class CreatePrerequisiteService implements CreatePrerequisiteUseCase {

    private final PrerequisiteRepository repository;

    public CreatePrerequisiteService(PrerequisiteRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreatePrerequisiteResult create(CreatePrerequisiteCommand command) {

        Prerequisite prerequisite = Prerequisite.create(
                command.subjectId(),
                command.prerequisiteSubjectId(),
                command.careerId(),
                command.description()
        );

        Prerequisite saved = repository.save(prerequisite);

        return new CreatePrerequisiteResult(saved);
    }
}
