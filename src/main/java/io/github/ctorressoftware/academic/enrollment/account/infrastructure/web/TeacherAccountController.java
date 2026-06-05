package io.github.ctorressoftware.academic.enrollment.account.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.teacher.CreateTeacherAccountCommand;
import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.teacher.CreateTeacherAccountResult;
import io.github.ctorressoftware.academic.enrollment.account.application.service.CreateTeacherAccountService;
import io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.request.CreateTeacherAccountRequest;
import io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.response.CreateTeacherAccountResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher/accounts")
public class TeacherAccountController {

    private final CreateTeacherAccountService teacherAccountService;

    public TeacherAccountController(CreateTeacherAccountService teacherAccountService) {
        this.teacherAccountService = teacherAccountService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CreateTeacherAccountResponse>> create(
            @RequestBody @Valid CreateTeacherAccountRequest request) {

        CreateTeacherAccountCommand command = new CreateTeacherAccountCommand(
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

        CreateTeacherAccountResult result = teacherAccountService.create(command);

        return ResponseEntity.ok(ApiResponse.success(new CreateTeacherAccountResponse(
                result.person(),
                result.teacher(),
                result.username(),
                result.accessToken())
        ));
    }
}
