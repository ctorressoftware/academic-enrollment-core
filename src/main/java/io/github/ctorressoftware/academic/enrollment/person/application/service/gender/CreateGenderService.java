package io.github.ctorressoftware.academic.enrollment.person.application.service.gender;

import io.github.ctorressoftware.academic.enrollment.person.application.port.in.gender.create.CreateGenderCommand;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.gender.create.CreateGenderResult;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.gender.create.CreateGenderUseCase;
import io.github.ctorressoftware.academic.enrollment.person.application.port.out.GenderRepository;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.gender.Gender;
import org.springframework.stereotype.Service;

@Service
public class CreateGenderService implements CreateGenderUseCase {

    private final GenderRepository repository;

    public CreateGenderService(GenderRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateGenderResult create(CreateGenderCommand command) {

        Gender gender = Gender.create(
                command.id(),
                command.code(),
                command.description()
        );

        Gender saved = repository.save(gender);

        return new CreateGenderResult(saved);
    }
}
