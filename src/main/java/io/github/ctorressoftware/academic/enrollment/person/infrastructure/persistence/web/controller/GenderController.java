package io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.web.controller;

import io.github.ctorressoftware.academic.enrollment.person.application.port.in.gender.create.CreateGenderCommand;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.gender.create.CreateGenderResult;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.gender.create.CreateGenderUseCase;
import io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.web.request.CreateGenderRequest;
import io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.web.response.CreateGenderResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/gender")
public class GenderController {

    private final CreateGenderUseCase useCase;

    public GenderController(CreateGenderUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CreateGenderResponse>> create(
            @RequestBody @Valid CreateGenderRequest request) {

        CreateGenderCommand command = new CreateGenderCommand(
                request.id(),
                request.code(),
                request.description()
        );

        CreateGenderResult result = useCase.create(command);

        return ResponseEntity.ok(ApiResponse.success(
                new CreateGenderResponse(result.gender())
        ));
    }
}
