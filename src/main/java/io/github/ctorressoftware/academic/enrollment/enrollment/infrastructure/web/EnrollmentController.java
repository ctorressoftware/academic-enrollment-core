package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enroll.CreateEnrollmentCommand;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enroll.CreateEnrollmentResult;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.enroll.CreateEnrollmentUseCase;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.getAllByStudentId.GetEnrollmentsByStudentIdCommand;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.getAllByStudentId.GetEnrollmentsByStudentIdResult;
import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.in.getAllByStudentId.GetEnrollmentsByStudentIdUseCase;
import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.web.request.CreateEnrollmentRequest;
import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.web.response.CreateEnrollmentResponse;
import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.web.response.GetEnrollmentsByStudentIdResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/enrollment")
public class EnrollmentController {

    private final CreateEnrollmentUseCase createEnrollmentService;
    private final GetEnrollmentsByStudentIdUseCase getByStudentIdService;

    public EnrollmentController(
            CreateEnrollmentUseCase createEnrollmentService,
            GetEnrollmentsByStudentIdUseCase getByStudentIdService) {
        this.createEnrollmentService = createEnrollmentService;
        this.getByStudentIdService = getByStudentIdService;
    }

    @PostMapping(value = "/enroll")
    ResponseEntity<ApiResponse<CreateEnrollmentResponse>> create(
            @RequestBody @Valid CreateEnrollmentRequest request) {

        CreateEnrollmentCommand command = new CreateEnrollmentCommand(
                request.studentId(),
                request.courseOfferingId(),
                request.enrollmentStateId()
        );

        CreateEnrollmentResult result = createEnrollmentService.enroll(command);

        return ResponseEntity.ok(ApiResponse.success(
                new CreateEnrollmentResponse(result.enrollment())
        ));
    }

    @GetMapping(value = "/getByStudentId")
    ResponseEntity<ApiResponse<GetEnrollmentsByStudentIdResponse>> getByStudentId(
            @RequestParam @Valid @NotNull(message = "studentId cannot be null") UUID studentId) {

        var command = new GetEnrollmentsByStudentIdCommand(studentId);

        GetEnrollmentsByStudentIdResult result =
                getByStudentIdService.getAllByStudentId(command);

        return ResponseEntity.ok(ApiResponse.success(
                new GetEnrollmentsByStudentIdResponse(result.enrollments())
        ));
    }
}
