package io.github.ctorressoftware.academic.enrollment.account.application.service;

import io.github.ctorressoftware.academic.enrollment.account.application.command.CreateAccountCommand;
import io.github.ctorressoftware.academic.enrollment.account.application.result.CreateAccountResult;
import io.github.ctorressoftware.academic.enrollment.account.application.usecase.CreateAccountUseCase;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.create.CreatePersonCommand;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.create.CreatePersonResult;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.create.CreatePersonUseCase;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.Document;

import static io.github.ctorressoftware.academic.enrollment.person.domain.model.DocumentType.*;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.Email;
import io.github.ctorressoftware.academic.enrollment.security.application.command.RegisterUserCommand;
import io.github.ctorressoftware.academic.enrollment.security.application.result.RegisterUserResult;
import io.github.ctorressoftware.academic.enrollment.security.application.usecase.RegisterUserUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateAccountService implements CreateAccountUseCase {

    private final CreatePersonUseCase createPersonUseCase;
    private final RegisterUserUseCase registerUserUseCase;

    public CreateAccountService(
            CreatePersonUseCase createPersonUseCase,
            RegisterUserUseCase registerUserUseCase) {
        this.createPersonUseCase = createPersonUseCase;
        this.registerUserUseCase = registerUserUseCase;
    }

    @Override
    @Transactional
    public CreateAccountResult create(CreateAccountCommand command) {

        CreatePersonCommand personCommand = new CreatePersonCommand(
                command.firstName(),
                command.middleName(),
                command.lastName(),
                command.secondLastName(),
                new Document(
                        DNI.getId() == command.documentTypeId() ? DNI : PASSPORT,
                        command.documentNumber()
                ),
                command.genderId(),
                new Email(command.email())
        );

        CreatePersonResult createPersonResult =
                createPersonUseCase.create(personCommand);

        RegisterUserCommand registerCommand = new RegisterUserCommand(
                createPersonResult.person().getId(),
                command.username(),
                command.password()
        );

        RegisterUserResult registerUserResult =
                registerUserUseCase.register(registerCommand);

        return new CreateAccountResult(
                createPersonResult.person(),
                registerUserResult.username(),
                registerUserResult.accessToken()
        );
    }
}
