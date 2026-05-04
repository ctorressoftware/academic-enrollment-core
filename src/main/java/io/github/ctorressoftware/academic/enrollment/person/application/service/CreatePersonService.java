package io.github.ctorressoftware.academic.enrollment.person.application.service;

import io.github.ctorressoftware.academic.enrollment.person.application.port.in.create.CreatePersonCommand;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.create.CreatePersonResult;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.create.CreatePersonUseCase;
import io.github.ctorressoftware.academic.enrollment.person.application.port.out.PersonRepository;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.Person;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonService implements CreatePersonUseCase {

    private final PersonRepository repository;

    public CreatePersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreatePersonResult create(CreatePersonCommand command) {

        Person person = repository.save(Person.create(
                command.firstName(),
                command.middleName(),
                command.lastName(),
                command.secondLastName(),
                command.document(),
                command.genderId(),
                command.email()
        ));

        return new CreatePersonResult(person);
    }
}
