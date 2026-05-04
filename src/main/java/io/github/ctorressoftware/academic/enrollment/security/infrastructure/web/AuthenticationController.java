package io.github.ctorressoftware.academic.enrollment.security.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.security.application.port.in.login.LoginCommand;
import io.github.ctorressoftware.academic.enrollment.security.application.port.in.login.LoginResult;
import io.github.ctorressoftware.academic.enrollment.security.application.port.in.login.LoginUseCase;
import io.github.ctorressoftware.academic.enrollment.security.infrastructure.web.request.LoginRequest;
import io.github.ctorressoftware.academic.enrollment.security.infrastructure.web.response.LoginResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final LoginUseCase loginUseCase;

    public AuthenticationController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
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
