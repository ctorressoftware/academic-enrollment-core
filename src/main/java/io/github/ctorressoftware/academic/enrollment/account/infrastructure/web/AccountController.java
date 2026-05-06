package io.github.ctorressoftware.academic.enrollment.account.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.CreateAccountCommand;
import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.CreateAccountResult;
import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.CreateStudentAccountCommand;
import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.CreateTeacherAccountCommand;
import io.github.ctorressoftware.academic.enrollment.account.application.service.CreateAccountService;
import io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.request.AccountType;
import io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.request.CreateAccountRequest;
import io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.response.CreateAccountResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final CreateAccountService service;

    public AccountController(CreateAccountService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CreateAccountResponse>> create(@RequestBody @Valid CreateAccountRequest request) {

        CreateAccountCommand command = resolveCommand(request);

        CreateAccountResult result = service.create(command);

        return ResponseEntity.ok(ApiResponse.success(new CreateAccountResponse(
                result.person(),
                result.username(),
                result.accessToken())
        ));
    }

    private CreateAccountCommand resolveCommand(CreateAccountRequest request) {

        return switch (request.accountType()) {
            case STUDENT -> new CreateStudentAccountCommand(
                    request.firstName(),
                    request.middleName(),
                    request.lastName(),
                    request.secondLastName(),
                    Objects.requireNonNull(request.careerId(), "careerId is required for student"),
                    request.documentTypeId(),
                    request.documentNumber(),
                    request.genderId(),
                    request.email(),
                    request.username(),
                    request.password()
            );
            case TEACHER -> new CreateTeacherAccountCommand(
                    request.firstName(),
                    request.middleName(),
                    request.lastName(),
                    request.secondLastName(),
                    request.documentTypeId(),
                    request.documentNumber(),
                    request.genderId(),
                    request.email(),
                    request.username(),
                    request.password()
            );
        };
    }
}
