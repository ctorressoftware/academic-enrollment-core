package io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.prerequisite.create.CreatePrerequisiteCommand;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.prerequisite.create.CreatePrerequisiteResult;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.prerequisite.create.CreatePrerequisiteUseCase;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.prerequisite.getallbysubjectid.GetAllBySubjectIdResult;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.prerequisite.getallbysubjectid.GetAllBySubjectIdUseCase;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.request.prerequisite.CreatePrerequisiteRequest;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.response.prerequisite.CreatePrerequisiteResponse;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.response.prerequisite.GetAllBySubjectIdResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/prerequisite")
public class PrerequisiteController {
    private final CreatePrerequisiteUseCase createUseCase;
    private final GetAllBySubjectIdUseCase getUseCase;

    public PrerequisiteController(
            CreatePrerequisiteUseCase createUseCase,
            GetAllBySubjectIdUseCase getUseCase) {
        this.createUseCase = createUseCase;
        this.getUseCase = getUseCase;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ApiResponse<CreatePrerequisiteResponse>> create(
            @RequestBody @Valid CreatePrerequisiteRequest request) {

        CreatePrerequisiteCommand command = new CreatePrerequisiteCommand(
                request.subjectId(),
                request.prerequisiteSubjectId(),
                request.careerId(),
                request.description()
        );

        CreatePrerequisiteResult result = createUseCase.create(command);

        return ResponseEntity.ok(ApiResponse.success(
                new CreatePrerequisiteResponse(result.prerequisite())
        ));
    }

    @GetMapping(value = "/getAllBySubjectId")
    public ResponseEntity<ApiResponse<GetAllBySubjectIdResponse>> getAllBySubjectId(
            @Valid @NotNull(message = "subjectId cannot be null") UUID subjectId) {

        GetAllBySubjectIdResult result = getUseCase.getAllBySubjectId(subjectId);

        return ResponseEntity.ok(ApiResponse.success(
                new GetAllBySubjectIdResponse(result.prerequisites())
        ));
    }
}
