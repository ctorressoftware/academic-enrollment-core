package io.github.ctorressoftware.academic.enrollment.account.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.student.CreateStudentAccountCommand;
import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.student.CreateStudentAccountResult;
import io.github.ctorressoftware.academic.enrollment.account.application.service.CreateStudentAccountService;
import io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.request.CreateStudentAccountRequest;
import io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.response.CreateStudentAccountResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/accounts")
public class StudentAccountController {

    private final CreateStudentAccountService studentAccountService;

    public StudentAccountController(CreateStudentAccountService studentAccountService) {
        this.studentAccountService = studentAccountService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CreateStudentAccountResponse>> create(
            @RequestBody @Valid CreateStudentAccountRequest request) {

        CreateStudentAccountCommand command = new CreateStudentAccountCommand(
                request.firstName(),
                request.middleName(),
                request.lastName(),
                request.secondLastName(),
                request.careerId(),
                request.documentTypeId(),
                request.documentNumber(),
                request.genderId(),
                request.email(),
                request.username(),
                request.password()
        );

        CreateStudentAccountResult result = studentAccountService.create(command);

        return ResponseEntity.ok(ApiResponse.success(new CreateStudentAccountResponse(
                result.person(),
                result.student(),
                result.username(),
                result.accessToken())
        ));
    }
}
