package io.github.ctorressoftware.academic.enrollment.account.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.account.application.command.CreateAccountCommand;
import io.github.ctorressoftware.academic.enrollment.account.application.result.CreateAccountResult;
import io.github.ctorressoftware.academic.enrollment.account.application.service.CreateAccountService;
import io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.request.CreateAccountRequest;
import io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.response.CreateAccountResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final CreateAccountService service;

    public AccountController(CreateAccountService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CreateAccountResponse>> create(@RequestBody @Valid CreateAccountRequest request) {

        CreateAccountCommand command = new CreateAccountCommand(
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

        CreateAccountResult result = service.create(command);

        return ResponseEntity.ok(ApiResponse.success(new CreateAccountResponse(
                result.person(),
                result.username(),
                result.accessToken())
        ));
    }
}
