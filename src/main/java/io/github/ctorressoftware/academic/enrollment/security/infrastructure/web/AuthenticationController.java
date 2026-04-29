package io.github.ctorressoftware.academic.enrollment.security.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.security.application.command.LoginCommand;
import io.github.ctorressoftware.academic.enrollment.security.application.command.RegisterUserCommand;
import io.github.ctorressoftware.academic.enrollment.security.application.result.LoginResult;
import io.github.ctorressoftware.academic.enrollment.security.application.result.RegisterUserResult;
import io.github.ctorressoftware.academic.enrollment.security.application.usecase.LoginUseCase;
import io.github.ctorressoftware.academic.enrollment.security.application.usecase.RegisterUserUseCase;
import io.github.ctorressoftware.academic.enrollment.security.infrastructure.web.request.LoginRequest;
import io.github.ctorressoftware.academic.enrollment.security.infrastructure.web.request.RegisterRequest;
import io.github.ctorressoftware.academic.enrollment.security.infrastructure.web.response.LoginResponse;
import io.github.ctorressoftware.academic.enrollment.security.infrastructure.web.response.RegisterResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUseCase loginUseCase;

    public AuthenticationController(
            RegisterUserUseCase registerUserUseCase,
            LoginUseCase loginUseCase) {
        this.registerUserUseCase = registerUserUseCase;
        this.loginUseCase = loginUseCase;

    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterResponse>> register(
            @RequestBody @Valid RegisterRequest request) {

        RegisterUserCommand command = new RegisterUserCommand(
                UUID.fromString(request.personId()),
                request.username(),
                request.password()
        );

        RegisterUserResult result = registerUserUseCase.register(command);

        return ResponseEntity.ok(ApiResponse.success(RegisterResponse.from(result)));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(
            @RequestBody @Valid LoginRequest request) {

        LoginCommand command = new LoginCommand(
                request.username(),
                request.password()
        );

        LoginResult result = loginUseCase.login(command);

        return ResponseEntity.ok(ApiResponse.success(LoginResponse.from(result)));
    }
}
