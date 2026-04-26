package io.github.ctorressoftware.academic.enrollment.security.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.security.infrastructure.web.request.RegisterRequest;
import io.github.ctorressoftware.academic.enrollment.security.infrastructure.web.response.RegisterResponse;
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

    @PostMapping("/login")
    public void login() {

    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterResponse>> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(ApiResponse.success(new RegisterResponse("user", "pass")));
    }
}
