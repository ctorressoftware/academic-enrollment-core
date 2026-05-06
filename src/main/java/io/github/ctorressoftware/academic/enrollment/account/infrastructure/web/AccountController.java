package io.github.ctorressoftware.academic.enrollment.account.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.student.CreateStudentAccountResult;
import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.student.CreateStudentAccountCommand;
import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.teacher.CreateTeacherAccountCommand;
import io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.teacher.CreateTeacherAccountResult;
import io.github.ctorressoftware.academic.enrollment.account.application.service.CreateStudentAccountService;
import io.github.ctorressoftware.academic.enrollment.account.application.service.CreateTeacherAccountService;
import io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.request.CreateStudentAccountRequest;
import io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.request.CreateTeacherAccountRequest;
import io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.response.CreateStudentAccountResponse;
import io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.response.CreateTeacherAccountResponse;
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

    private final CreateStudentAccountService studentAccountService;
    private final CreateTeacherAccountService teacherAccountService;

    public AccountController(
            CreateStudentAccountService studentAccountService,
            CreateTeacherAccountService teacherAccountService) {
        this.studentAccountService = studentAccountService;
        this.teacherAccountService = teacherAccountService;
    }

    @PostMapping("/create/student")
    public ResponseEntity<ApiResponse<CreateStudentAccountResponse>> createStudent(
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

    @PostMapping("/create/teacher")
    public ResponseEntity<ApiResponse<CreateTeacherAccountResponse>> createTeacher(
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
