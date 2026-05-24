package io.github.ctorressoftware.academic.enrollment.account.application.service;

import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.student.CreateStudentAccountResult;
import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.student.CreateStudentAccountCommand;
import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.student.CreateStudentAccountUseCase;
import io.github.ctorressoftware.academic.enrollment.account.domain.enums.RoleType;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.person.create.CreatePersonCommand;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.person.create.CreatePersonResult;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.person.create.CreatePersonUseCase;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.person.Document;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.documenttype.DocumentTypeCode;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.person.Email;
import io.github.ctorressoftware.academic.enrollment.security.application.port.in.register.RegisterUserCommand;
import io.github.ctorressoftware.academic.enrollment.security.application.port.in.register.RegisterUserResult;
import io.github.ctorressoftware.academic.enrollment.security.application.port.in.register.RegisterUserUseCase;
import io.github.ctorressoftware.academic.enrollment.shared.application.port.out.UnitOfWork;
import io.github.ctorressoftware.academic.enrollment.student.application.port.in.create.CreateStudentCommand;
import io.github.ctorressoftware.academic.enrollment.student.application.port.in.create.CreateStudentResult;
import io.github.ctorressoftware.academic.enrollment.student.application.port.in.create.CreateStudentUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateStudentAccountService implements CreateStudentAccountUseCase {
    private final CreatePersonUseCase createPersonUseCase;
    private final CreateStudentUseCase studentUseCase;
    private final RegisterUserUseCase registerUserUseCase;
    private final UnitOfWork unitOfWork;

    public CreateStudentAccountService(
            CreatePersonUseCase createPersonUseCase,
            CreateStudentUseCase studentUseCase,
            RegisterUserUseCase registerUserUseCase,
            UnitOfWork unitOfWork) {
        this.createPersonUseCase = createPersonUseCase;
        this.studentUseCase = studentUseCase;
        this.registerUserUseCase = registerUserUseCase;
        this.unitOfWork = unitOfWork;
    }

    @Override
    @Transactional
    public CreateStudentAccountResult create(CreateStudentAccountCommand command) {

        Document document = new Document(
                DocumentTypeCode.getById(command.documentTypeId()),
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

        CreateStudentCommand createStudentCommand = new CreateStudentCommand(
                createPersonResult.person().getId(),
                command.careerId()
        );

        CreateStudentResult createStudentResult =
                studentUseCase.create(createStudentCommand);

        RegisterUserCommand registerCommand = new RegisterUserCommand(
                createPersonResult.person().getId(),
                RoleType.STUDENT.getId(),
                command.username(),
                command.password()
        );

        RegisterUserResult registerUserResult =
                registerUserUseCase.register(registerCommand);

        return new CreateStudentAccountResult(
                createPersonResult.person(),
                createStudentResult.student(),
                registerUserResult.username(),
                registerUserResult.accessToken()
        );
    }
}
