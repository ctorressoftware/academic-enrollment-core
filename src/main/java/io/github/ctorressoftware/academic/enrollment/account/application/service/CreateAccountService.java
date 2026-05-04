package io.github.ctorressoftware.academic.enrollment.account.application.service;

import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.CreateAccountCommand;
import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.CreateAccountResult;
import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.CreateAccountUseCase;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.create.CreatePersonCommand;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.create.CreatePersonResult;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.create.CreatePersonUseCase;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.Document;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.DocumentType;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.Email;
import io.github.ctorressoftware.academic.enrollment.security.application.command.RegisterUserCommand;
import io.github.ctorressoftware.academic.enrollment.security.application.port.in.register.RegisterUserResult;
import io.github.ctorressoftware.academic.enrollment.security.application.port.in.register.RegisterUserUseCase;
import io.github.ctorressoftware.academic.enrollment.shared.application.port.out.UnitOfWork;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateAccountService implements CreateAccountUseCase {
    private final CreatePersonUseCase createPersonUseCase;
    private final RegisterUserUseCase registerUserUseCase;
    private final UnitOfWork unitOfWork;

    public CreateAccountService(
            CreatePersonUseCase createPersonUseCase,
            RegisterUserUseCase registerUserUseCase,
            UnitOfWork unitOfWork) {
        this.createPersonUseCase = createPersonUseCase;
        this.registerUserUseCase = registerUserUseCase;
        this.unitOfWork = unitOfWork;
    }

    @Override
    @Transactional
    public CreateAccountResult create(CreateAccountCommand command) {

        Document document = new Document(
                DocumentType.getById(command.documentTypeId()),
                command.documentNumber()
        );

        CreatePersonCommand personCommand = new CreatePersonCommand(
                command.firstName(),
                command.middleName(),
                command.lastName(),
                command.secondLastName(),
                document,
                command.genderId(),
                new Email(command.email())
        );

        CreatePersonResult createPersonResult =
                createPersonUseCase.create(personCommand);

        unitOfWork.flush();
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
