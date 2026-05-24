package io.github.ctorressoftware.academic.enrollment.account.application.service;

import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.teacher.CreateTeacherAccountCommand;
import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.teacher.CreateTeacherAccountResult;
import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.teacher.CreateTeacherAccountUseCase;
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
import io.github.ctorressoftware.academic.enrollment.teacher.application.port.in.create.CreateTeacherCommand;
import io.github.ctorressoftware.academic.enrollment.teacher.application.port.in.create.CreateTeacherResult;
import io.github.ctorressoftware.academic.enrollment.teacher.application.port.in.create.CreateTeacherUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateTeacherAccountService implements CreateTeacherAccountUseCase {
    private final CreatePersonUseCase createPersonUseCase;
    private final CreateTeacherUseCase teacherUseCase;
    private final RegisterUserUseCase registerUserUseCase;
    private final UnitOfWork unitOfWork;

    public CreateTeacherAccountService(
            CreatePersonUseCase createPersonUseCase,
            CreateTeacherUseCase teacherUseCase,
            RegisterUserUseCase registerUserUseCase,
            UnitOfWork unitOfWork) {
        this.createPersonUseCase = createPersonUseCase;
        this.teacherUseCase = teacherUseCase;
        this.registerUserUseCase = registerUserUseCase;
        this.unitOfWork = unitOfWork;
    }

    @Override
    @Transactional
    public CreateTeacherAccountResult create(CreateTeacherAccountCommand command) {

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

        CreateTeacherCommand createTeacherCommand =
                new CreateTeacherCommand(createPersonResult.person().getId());

        CreateTeacherResult createTeacherResult =
                teacherUseCase.create(createTeacherCommand);

        RegisterUserCommand registerCommand = new RegisterUserCommand(
                createPersonResult.person().getId(),
                RoleType.TEACHER.getId(),
                command.username(),
                command.password()
        );

        RegisterUserResult registerUserResult =
                registerUserUseCase.register(registerCommand);

        return new CreateTeacherAccountResult(
                createPersonResult.person(),
                createTeacherResult.teacher(),
                registerUserResult.username(),
                registerUserResult.accessToken()
        );
    }
}
