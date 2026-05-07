package io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.create.CreateSubjectCommand;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.create.CreateSubjectResult;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.getAll.GetAllSubjectsCommand;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.getAll.GetAllSubjectsResult;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.getByCode.GetSubjectByCodeCommand;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.getByCode.GetSubjectByCodeResult;
import io.github.ctorressoftware.academic.enrollment.subject.application.service.CreateSubjectService;
import io.github.ctorressoftware.academic.enrollment.subject.application.service.GetAllSubjectsService;
import io.github.ctorressoftware.academic.enrollment.subject.application.service.GetSubjectByCodeService;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.request.CreateSubjectRequest;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.request.GetAllSubjectsRequest;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.request.GetSubjectByCodeRequest;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.response.CreateSubjectResponse;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.response.GetAllSubjectsResponse;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.response.GetSubjectByCodeResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/subject")
public class SubjectController {
    private final CreateSubjectService createService;
    private final GetAllSubjectsService getAllService;
    private final GetSubjectByCodeService getByCodeService;

    public SubjectController(
            CreateSubjectService createService,
            GetAllSubjectsService getAllService,
            GetSubjectByCodeService getByCodeService) {
        this.createService = createService;
        this.getAllService = getAllService;
        this.getByCodeService = getByCodeService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ApiResponse<CreateSubjectResponse>> create(
            @RequestBody @Valid CreateSubjectRequest request) {

        CreateSubjectCommand command = new CreateSubjectCommand(
                request.code(),
                request.description()
        );

        CreateSubjectResult result = createService.create(command);

        return ResponseEntity.ok(ApiResponse.success(
                new CreateSubjectResponse(result.subject())
        ));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<ApiResponse<GetAllSubjectsResponse>> getAll(
            GetAllSubjectsRequest request) {

        GetAllSubjectsCommand command = new GetAllSubjectsCommand(
                request.page(),
                request.pageSize()
        );

        GetAllSubjectsResult result = getAllService.getAll(command);

        return ResponseEntity.ok(ApiResponse.success(
                new GetAllSubjectsResponse(result.subjects())
        ));
    }

    @GetMapping(value = "/get")
    public ResponseEntity<ApiResponse<GetSubjectByCodeResponse>> get(
            GetSubjectByCodeRequest request) {

        GetSubjectByCodeCommand command = new GetSubjectByCodeCommand(request.code());

        GetSubjectByCodeResult result = getByCodeService.getByCode(command);

        return ResponseEntity.ok(ApiResponse.success(
                new GetSubjectByCodeResponse(result.subject())
        ));
    }
}
