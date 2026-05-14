package io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.web.controller;

import io.github.ctorressoftware.academic.enrollment.person.application.port.in.documenttype.create.CreateDocumentTypeCommand;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.documenttype.create.CreateDocumentTypeResult;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.documenttype.create.CreateDocumentTypeUseCase;
import io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.web.request.CreateDocumentTypeRequest;
import io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.web.response.CreateDocumentTypeResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/documenttype")
public class DocumentTypeController {
    private final CreateDocumentTypeUseCase useCase;

    public DocumentTypeController(CreateDocumentTypeUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CreateDocumentTypeResponse>> create(
            @RequestBody @Valid CreateDocumentTypeRequest request) {

        CreateDocumentTypeCommand command = new CreateDocumentTypeCommand(
                request.id(),
                request.code(),
                request.description()
        );

        CreateDocumentTypeResult result = useCase.create(command);

        return ResponseEntity.ok(ApiResponse.success(
                new CreateDocumentTypeResponse(result.documentType())
        ));
    }
}
