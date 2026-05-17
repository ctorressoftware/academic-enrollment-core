package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.state.create.CreateEnrollmentStateCommand;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.state.create.CreateEnrollmentStateResult;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.state.create.CreateEnrollmentStateUseCase;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.state.getall.GetAllEnrollmentStatesResult;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.state.getall.GetAllEnrollmentStatesUseCase;
import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.web.request.CreateEnrollmentStateRequest;
import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.web.response.CreateEnrollmentStateResponse;
import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.web.response.GetAllEnrollmentStatesResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollment-state")
public class EnrollmentStateController {

    private final CreateEnrollmentStateUseCase createService;
    private final GetAllEnrollmentStatesUseCase getAllService;

    public EnrollmentStateController(
            CreateEnrollmentStateUseCase createService,
            GetAllEnrollmentStatesUseCase getAllService) {
        this.createService = createService;
        this.getAllService = getAllService;
    }

    @PostMapping(value = "/create")
    ResponseEntity<ApiResponse<CreateEnrollmentStateResponse>> create(
            CreateEnrollmentStateRequest request) {

        CreateEnrollmentStateCommand command = new CreateEnrollmentStateCommand(
                request.id(),
                request.code(),
                request.description()
        );

        CreateEnrollmentStateResult result = createService.create(command);
        return ResponseEntity.ok(ApiResponse.success(
                new CreateEnrollmentStateResponse(result.state())
        ));
    }

    @GetMapping(value = "/getAll")
    ResponseEntity<ApiResponse<GetAllEnrollmentStatesResponse>> getAll() {
        GetAllEnrollmentStatesResult result = getAllService.getAll();
        return ResponseEntity.ok(ApiResponse.success(
                new GetAllEnrollmentStatesResponse(result.states())
        ));
    }
}
