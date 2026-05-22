package io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.create.CreateSubjectCommand;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.create.CreateSubjectResult;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.getAll.GetAllSubjectsCommand;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.getAll.GetAllSubjectsResult;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.getByCode.GetSubjectByCodeCommand;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.getByCode.GetSubjectByCodeResult;
import io.github.ctorressoftware.academic.enrollment.subject.application.service.subject.CreateSubjectService;
import io.github.ctorressoftware.academic.enrollment.subject.application.service.subject.GetAllSubjectsService;
import io.github.ctorressoftware.academic.enrollment.subject.application.service.subject.GetSubjectByCodeService;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.request.subject.CreateSubjectRequest;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.request.subject.GetAllSubjectsRequest;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.request.subject.GetSubjectByCodeRequest;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.response.subject.CreateSubjectResponse;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.response.subject.GetAllSubjectsResponse;
import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.response.subject.GetSubjectByCodeResponse;
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
